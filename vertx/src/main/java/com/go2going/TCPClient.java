package com.go2going;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;

import java.util.Scanner;

/**
 * 项目名称：  testcode<br>
 * 类名称：  TCPClient<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/10 0010 14:55
 */
public class TCPClient {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        NetClient client = vertx.createNetClient();
        client.connect(3456, "localhost", res -> {
            if (res.succeeded()) {
                System.out.println("Connected!");
                NetSocket socket = res.result();

                socket.handler(event -> System.out.println(event.toString()));
                new Thread(() -> {
                    Scanner scanner = new Scanner(System.in);

                    while (scanner.hasNext()) {

                        socket.write(scanner.next());
                    }
                }).start();
            } else {
                System.out.println("Failed to connect: " + res.cause().getMessage());
            }
        });


    }
}
