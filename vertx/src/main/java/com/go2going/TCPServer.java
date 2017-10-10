package com.go2going;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.net.NetServer;

/**
 * 项目名称：  testcode<br>
 * 类名称：  TCPServer<br>
 * 描述：只能使用一个核心，多核cpu，请添加多个实例，参考doc文档
 *
 * @author wangqiang
 * 创建时间：  2017/10/10 0010 14:46
 */
public class TCPServer {
    public static void main(String[] args) {
        //vertx实例默认是由2XCpu个eventLoop，但是例如下面的server verticle只有一个eventLoop，所以当只有一个verticle时
        //通过多个instance实现多核的利用，但是注意一个vertx总的eventloop是固定的，所以instance不要超过总的loop
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new TempVerticle(),new DeploymentOptions().setInstances(4));
    }

}

class TempVerticle  extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        NetServer server = vertx.createNetServer();
        server.connectStream().handler(event -> {
            event.handler(buffer -> System.out.println(buffer.toString()));
        }).endHandler(event -> System.out.println("End!!!!"));
        server.listen(3456,"localhost",event -> {
            if (event.succeeded()) {
                System.out.println("Server is now listening!");
            } else {
                System.out.println("Failed to bind!");
            }
        });
    }
}