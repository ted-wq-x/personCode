package com.go2going;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import static org.apache.zookeeper.Watcher.Event.KeeperState.Disconnected;
import static org.apache.zookeeper.Watcher.Event.KeeperState.SyncConnected;

/**
 * 项目名称：  testcode<br>
 * 类名称：  ZookeeperUtils<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/9 0009 17:29
 */
public class ZookeeperUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ZookeeperUtils.class);

    //配置信息
    private static final Map<String, String> map = new HashMap<>();

    private static final CountDownLatch count = new CountDownLatch(1);

    private static ZooKeeper zooKeeper;

    private ZookeeperUtils(){}

     static  {
        JsonParser jsonParser = new JsonParser();
        InputStream resourceAsStream = ZookeeperUtils.class.getResourceAsStream("/config.json");
        JsonElement parse = jsonParser.parse(new InputStreamReader(resourceAsStream));
        JsonObject jsonObject = parse.getAsJsonObject();
        jsonObject.entrySet().forEach(entity -> {
            map.put(entity.getKey(), entity.getValue().getAsString());
        });
    }


    private static void initZk() {
        try {
            zooKeeper = new ZooKeeper(map.get("zkUrl"), 30000, event -> {
                if (event.getState() == SyncConnected) {
                    count.countDown();
                    LOGGER.info("ZK connect success!");
                } else if (event.getState() == Disconnected) {
                    zooKeeper = null;
                    LOGGER.info("ZK disConnect and set zooKeeper=null !");
                }
            });
            count.await();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ZooKeeper getZooKeeper() {
        if (zooKeeper == null) {
            synchronized (ZookeeperUtils.class) {
                if (zooKeeper == null) {
                    initZk();
                    close();//添加jvm钩子
                }
            }
        }
        return zooKeeper;
    }


    /**
     * 在jvm关闭时，关闭连接
     */
    private static void close() {

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public synchronized void start() {
                try {
                    if (zooKeeper == null) {
                        return;
                    }
                    zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
