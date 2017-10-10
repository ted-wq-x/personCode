package com.go2going;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;
import io.vertx.ext.web.handler.sockjs.PermittedOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * 项目名称：  testcode<br>
 * 类名称：  EventBus<br>
 * 描述：使用桥接将js的bus和server bus连接在一起,使用的是websocket bridge
 *      访问index.html
 *
 * @author wangqiang
 * 创建时间：  2017/10/10 0010 10:46
 */
public class EventBus {

    public static void main(String[] args) {

        Vertx.vertx().deployVerticle(new AbstractVerticle() {
            @Override
            public void start() throws Exception {
                Router router = Router.router(vertx);

                // Allow events for the designated addresses in/out of the event bus bridge
                BridgeOptions opts = new BridgeOptions()
                        .addInboundPermitted(new PermittedOptions().setAddress("chat.to.server"))
                        .addOutboundPermitted(new PermittedOptions().setAddress("chat.to.client"));

                // Create the event bus bridge and add it to the router.
                SockJSHandler ebHandler = SockJSHandler.create(vertx).bridge(opts);
                router.route("/eventbus/*").handler(ebHandler);

                // Create a router endpoint for the static content.
                router.route().handler(StaticHandler.create());

                // Start the web server and tell it to use the router to handle requests.
                vertx.createHttpServer().requestHandler(router::accept).listen(8080);

                io.vertx.core.eventbus.EventBus eb = vertx.eventBus();

                // Register to listen for messages coming IN to the server
                eb.consumer("chat.to.server").handler(message -> {
                    // Create a timestamp string
                    String timestamp = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(Date.from(Instant.now()));
                    // Send the message back out to all clients with the timestamp prepended.
                    eb.publish("chat.to.client", timestamp + ": " + message.body());
                });
            }
        });


    }



}


class BusConsumer {
    private io.vertx.core.eventbus.EventBus eventBus;

    public io.vertx.core.eventbus.EventBus getEventBus() {
        return eventBus;
    }

    public void setEventBus(io.vertx.core.eventbus.EventBus eventBus) {
        this.eventBus = eventBus;
    }
}