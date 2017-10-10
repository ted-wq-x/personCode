package com.go2going;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

/**
 * 项目名称：  testcode<br>
 * 类名称：  MainVerticle<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/30 0030 10:42
 */
public class MainVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) throws Exception {
//        super.start(startFuture);
        System.out.println("starting----------------------");
        startFuture.complete();
        
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
