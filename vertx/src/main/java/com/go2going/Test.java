package com.go2going;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.MessageConsumer;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Test<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/10 0010 13:25
 */
public class Test {
    public static void main(String[] args) {
        BusConsumer busConsumer = new BusConsumer();
        VertxOptions options = new VertxOptions();
        Vertx.clusteredVertx(options, res -> {
            if (res.succeeded()) {
                Vertx vertx = res.result();
                io.vertx.core.eventbus.EventBus eventBus = vertx.eventBus();
                busConsumer.setEventBus(eventBus);
            } else {
                System.out.println("Failed: " + res.cause());
            }
        });

        io.vertx.core.eventbus.EventBus eventBus = busConsumer.getEventBus();
         eventBus.publish("com.go2going", "hello world");

    }
}
