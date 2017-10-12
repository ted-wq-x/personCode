package com.go2going.pubandsub;

import com.go2going.ZookeeperUtils;
import com.go2going.naming.Provider;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Main<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/9 0009 17:27
 */
public class Main {
    private static final   Provider client = new Provider("/configuration", "/com.go2going", "", "/resource", "/name");
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) throws KeeperException, InterruptedException {

        ZooKeeper zooKeeper = ZookeeperUtils.getZooKeeper();
        client.createNode();

        new Thread(() -> {
                String allPath = client.getAllPath();
                ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
                scheduledExecutorService.scheduleAtFixedRate(() -> {
                    //发送两次之后，结束
                    if (atomicInteger.getAndIncrement() == 2) {
                        countDownLatch.countDown();
                        scheduledExecutorService.shutdown();
                        return;
                    }
                    try {
                        zooKeeper.setData(allPath, String.valueOf(System.currentTimeMillis()).getBytes(), -1);
                    } catch (KeeperException | InterruptedException e) {
                        e.printStackTrace();
                        try {
                            zooKeeper.close();
                            countDownLatch.countDown();
                            System.exit(-1);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    System.out.println("发了");
                }, 5,5, TimeUnit.SECONDS);

        }).start();

        /**
         * 主动断开连接，让主动zk删除节点，否则会出现创建节点失败的情况（zk有恢复连接的延迟）
         */
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                zooKeeper.close();
                System.out.println("gaun");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

        String path = client.getAllPath();

        sub(path, zooKeeper);

        countDownLatch.await();

        System.out.println("------------");
    }
    public static void sub(String path,ZooKeeper zooKeeper) {

        zooKeeper.getData(path, event -> {
            if (event.getType() == Watcher.Event.EventType.NodeDataChanged) {
                //重新订阅watch
                sub(path, zooKeeper);
            }
        }, (rc, path1, ctx, data, stat) ->{
            System.out.println(new String(data));
        },null);


    }
}
