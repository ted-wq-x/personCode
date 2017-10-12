package com.go2going.queue;

import com.go2going.ZookeeperUtils;
import com.go2going.naming.Provider;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 项目名称：  testcode<br>
 * 类名称：  ZkDistributedFIFOQueue<br>
 * 描述：在指定path下创建顺序子节点，序号从小到大递增，出队时获取序号小的节点
 *
 * @author wangqiang
 * 创建时间：  2017/10/12 0012 14:23
 */
public class ZkDistributedFIFOQueue {
    private static final Provider client = new Provider("/configuration", "/com.go2going", "", "/resource",
            "");
    private static ZooKeeper zk = ZookeeperUtils.getZooKeeper();


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        String allPath = client.getAllPath();
        for (int i = 0; i < 10; i++) {
            try {
               zk.create(allPath + "/fifo_queue_", ("fifo--"+i).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                        CreateMode.EPHEMERAL_SEQUENTIAL);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Runnable run=() -> {

            String id= Thread.currentThread().getName();
            while (true) {
                try {
                    Thread.sleep(3000);
                    List<String> children = zk.getChildren(allPath, false);
                    zk.transaction();

                    if (!children.isEmpty()) {
                        Collections.sort(children);
                        byte[] data = zk.getData(allPath+"/"+children.get(0), false, new Stat());
                        zk.delete(allPath + "/" + children.get(0), -1,(rc, path, ctx) -> {

                        },null);
                        System.out.println(id+"获取值" + new String(data));
                    } else {
                        countDownLatch.countDown();
                        break;
                    }
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
            }
        };
        new Thread(run).start();
        new Thread(run).start();

        countDownLatch.await();
        System.out.println("OVER!!!!!!");
    }
}
