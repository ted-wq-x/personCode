package com.go2going;

import io.vertx.core.*;

/**
 * @author BlueT
 * 2017/10/4 14:06
 */
public class VertxTest {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MyVerticle(),new DeploymentOptions().setWorker(true));


    }
}

/**
 *
 */
class MyVerticle extends AbstractVerticle {
    /**
     * 异步启动
     * @param startFuture
     * @throws Exception
     */
    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.deployVerticle("wangqiang_test",event -> {
            if (event.succeeded()) {
                System.out.println(event.result());
                startFuture.complete();
            } else {
                startFuture.failed();
            }
        });

    }

    /**
     * 异步停止
     * @param stopFuture
     * @throws Exception
     */
    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        super.stop(stopFuture);
    }
}


