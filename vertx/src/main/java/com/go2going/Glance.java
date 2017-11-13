package com.go2going;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Glance<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/29 0029 15:29
 */
public class Glance {
    private static  Vertx vertx = Vertx.vertx();


    public static void main(String[] args) {

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

        vertx.deployVerticle(new MainVerticle());


    }


    static void httpServer(){
        HttpServer httpServer = vertx.createHttpServer(new HttpServerOptions().setLogActivity(true));
        httpServer.requestHandler(event ->{


            System.out.println(event.getParam("name"));

            event.response().end("hello world");
        });


        httpServer.listen(8080, "127.0.0.1",event -> {
            if (event.succeeded()) {
                System.out.println("Server is now listening!");
            } else {
                System.out.println("Failed to bind!");
            }
        });
    }
}
