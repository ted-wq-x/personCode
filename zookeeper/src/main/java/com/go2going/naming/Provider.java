package com.go2going.naming;

import com.go2going.ZookeeperUtils;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Provider<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/11 0011 11:24
 */
public class Provider {

    private static final ZooKeeper zooKeeper = ZookeeperUtils.getZooKeeper();

    // 根节点
    private final String rootNode;


    private final String serviceNode;

    //暴露的服务
    private final String clazz;

    // provider or consumer
    private final String businessNode;

    //ip+port
    private final String hostNode;

    public Provider(String rootNode, String serviceNode, String clazz, String businessNode, String hostNode) {
        this.rootNode = rootNode;
        this.serviceNode = this.rootNode + serviceNode;
        this.clazz = clazz;
        this.businessNode = this.serviceNode + businessNode;
        this.hostNode = this.businessNode+hostNode;
    }

    public String getAllPath(){
        return this.hostNode;
    }

    public ZooKeeper getZooKeeper(){
        return this.zooKeeper;
    }


    /**
     * 需要确认上层节点是否存在，上层节点都是持久化的，最底层的是EPHEMERAL
     */
    public void createNode() {

        try {
            boolean result = create(rootNode, rootNode, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new
                    CreateDubboCallback(), "create root node");
            if (!result) {
                result = create(serviceNode, serviceNode, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new
                        CreateServiceCallback(), "create service node");
            }
            if (!result) {
                result = create(businessNode, businessNode, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new
                        CreateProviderCallback(), "create provider node");
            }
            if (!result) {
                create(hostNode, clazz, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            }
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    // 记录当前取得节点，用于负载均衡
    private static AtomicInteger index = new AtomicInteger(0);

    public String getData(String path) throws KeeperException, InterruptedException {
        String host;

        List<String> children = zooKeeper.getChildren(path, false);
        if (children == null || children.size() <= 0)
            return null;
        if (index.get() >= children.size()) {
            index.set(0);
            host = children.get(index.get());
        } else {
            host = children.get(index.getAndIncrement());
        }
        Stat stat = new Stat();
        byte[] data = zooKeeper.getData(path + "/" + host, null, stat);
        String serviceName = new String(data);

        return host + serviceName;
    }

    public void setData(String value,String path) {
        try {
            zooKeeper.setData(path, value != null ? value.getBytes() : null, -1);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create synchronized node
     *
     * @param path       shi ip+port
     * @param data       clazz
     * @param acl
     * @param createMode
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void create(String path, String data, List<ACL> acl, CreateMode createMode) throws KeeperException,
            InterruptedException {
        Stat rootStat = zooKeeper.exists(path, false);
        if (rootStat == null) {
            zooKeeper.create(path, data.getBytes(), acl, createMode);
        }
    }

    /**
     * Create a asynchronized node
     *
     * @param path
     * @param data
     * @param acl
     * @param createMode
     * @param cb
     * @param ctx
     * @throws KeeperException
     * @throws InterruptedException
     */
    public boolean create(String path, String data, List<ACL> acl, CreateMode createMode, AsyncCallback
            .StringCallback cb, Object ctx) throws KeeperException, InterruptedException {
        Stat rootStat = zooKeeper.exists(path, false);
        boolean result = false;
        if (rootStat == null) {
            zooKeeper.create(path, data.getBytes(), acl, createMode, cb, ctx);
            result = true;
        }
        return result;
    }


    /**
     * Create dubbo node callback by WatcherManager
     */
    class CreateDubboCallback implements AsyncCallback.StringCallback {

        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.out.println("Create dubbo node callback by WatcherManager");
            if (path == null || "".equals(path)) {
                System.out.println("Create " + path + " failure!");
                return;
            } else {
                System.out.println("Create " + path + " success!");
            }
            try {
                // Create service node
                create(serviceNode, serviceNode, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new
                        CreateServiceCallback(), "create service node");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Create service node callback by WatcherManager
     */
    class CreateServiceCallback implements AsyncCallback.StringCallback {

        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.out.println("Create service node callback by WatcherManager");
            if (path == null || "".equals(path)) {
                System.out.println("Create " + path + " failure!");
                return;
            } else {
                System.out.println("Create " + path + " success!");
            }
            //  Create service node
            try {
                create(businessNode, businessNode, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new
                        CreateProviderCallback(), "create provider node");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Create provider node callback by WatcherManager
     */
    class CreateProviderCallback implements AsyncCallback.StringCallback {

        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.out.println("Create provide node callback by WatcherManager");
            if (path == null || "".equals(path)) {
                System.out.println("Create " + path + " failure!");
                return;
            } else {
                System.out.println("Create " + path + " success!");
            }
            // create host node
            try {
                create(hostNode, clazz, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 由于是强效关闭jvm，所以节点会存在一定的延迟才会消失
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Provider client = new Provider("/dubbo", "/org.zk.naming.HelloWorldService", "/org.zk.naming.HelloWorldServiceImpl",
                "/providers", "/127.0.0.1:20881");
        client.createNode();

        client = new Provider("/dubbo", "/org.zk.naming.HelloWorldService", "/org.zk.naming.HelloWorldServiceImpl", "/providers", "/127.0.0.1:20882");
        client.createNode();

        System.out.println("Provider Ok!!!!!");
        CountDownLatch semaphore = new CountDownLatch(1);
        semaphore.await();
    }
}
