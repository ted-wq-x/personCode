package com.go2going;

import io.vertx.core.Vertx;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Glance<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/29 0029 15:29
 */
public class Glance {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        //第一种执行阻塞的代码
        vertx.executeBlocking(event -> {
            try {
                event.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.complete("hello world");
        }, event -> {
            System.out.println(event.result());
        });

        //第二种执行阻塞代码的方式是使用work verticle，默认就是使用这种方式，使用 setWorkerPoolSize.配置池队列大小


    }
}
