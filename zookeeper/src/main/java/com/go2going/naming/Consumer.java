package com.go2going.naming;

import org.apache.zookeeper.KeeperException;

import java.util.concurrent.CountDownLatch;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Consumer<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/11 0011 16:18
 */
public class Consumer {

    /**
     * 从结果看出，providers在顺序切换
     * @param args
     * @throws InterruptedException
     * @throws KeeperException
     */
    public static void main(String[] args) throws InterruptedException, KeeperException {
        Provider client = new Provider("/dubbo", "/org.zk.naming.HelloWorldService", "", "/consumers", "/127.0.0.1:2181");
        client.createNode();

        String serviceName = client.getData("/dubbo/org.zk.naming.HelloWorldService/providers");
        System.out.println("The provider info: " + serviceName);

        serviceName = client.getData("/dubbo/org.zk.naming.HelloWorldService/providers");
        System.out.println("The provider info: " + serviceName);

        serviceName = client.getData("/dubbo/org.zk.naming.HelloWorldService/providers");
        System.out.println("The provider info: " + serviceName);
        CountDownLatch semaphore = new CountDownLatch(1);


        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.countDown();
        }).start();
        semaphore.await();
    }
}
