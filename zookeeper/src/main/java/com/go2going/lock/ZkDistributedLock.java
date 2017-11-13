package com.go2going.lock;

import com.go2going.ZookeeperUtils;
import com.go2going.naming.Provider;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * 项目名称：  testcode<br>
 * 类名称：  ZkDistributedLock<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/12 0012 10:39
 */
public class ZkDistributedLock {

    private static final Provider client = new Provider("/configuration", "/com.go2going", "", "/resource",
            "");

    private static Map<Integer, String> nodes = new HashMap<>();

    private static ZooKeeper zk = ZookeeperUtils.getZooKeeper();

    public static void main(String[] args) throws KeeperException, InterruptedException {
        Random random = new Random();

        //生成所有节点
        for (int i = 0; i < 10; i++) {
            getDistributedLock(i);
        }
        CountDownLatch countDownLatch = new CountDownLatch(10);

        //删除节点，后一个节点获取锁
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String s = nodes.get(i);
                if (s != null) {
                    try {
                        System.out.println(i + "本节点已不在了...");
                        zk.delete(s, -1);
                        nodes.remove(i);
                        countDownLatch.countDown();
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
        countDownLatch.await();
        System.out.println("结束");
    }


    public static void getDistributedLock(int i) {

        String allPath = client.getAllPath();

        try {

            String path = zk.create(allPath + "/guid-lock", "lock".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL);

            String nodeName = path.substring(allPath.length() + 1);

            nodes.put(i, path);

            List<String> children = zk.getChildren(allPath, true);


            if (!children.isEmpty()) {
                Collections.sort(children);
                // 避免羊群效应
                // 首先找到比自己小的那个节点
                int index = children.indexOf(nodeName);
                switch (index) {
                    case -1: {
                        System.out.println(i + "本节点已不在了..." + path);
                        break;
                    }
                    case 0: {
                        System.out.println(i + "子节点中，我最小，可以获得锁了！哈哈" + path);
                        break;
                    }
                    default: {
                        //找到比自己小一号的节点，添加watch
                        String waitPath = allPath + "/" + children.get(index - 1);
                        System.out.println(i + "排在我前面的节点是 " + waitPath);
                        try {

                            zk.getData(waitPath, event -> {
                                System.out.println(i + "子节点中，我最小，可以获得锁了！哈哈" + event.getPath());
                            }, new Stat());
                            break;
                        } catch (KeeperException e) {
                            if (zk.exists(waitPath, false) == null) {
                                System.out.println(i + "排在我前面的" + waitPath + "已消失 ");
                                getDistributedLock(i);
                            } else {
                                throw e;
                            }
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
