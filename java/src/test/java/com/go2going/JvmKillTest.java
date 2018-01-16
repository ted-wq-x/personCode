package com.go2going;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 项目名称：  testcode<br>
 * 类名称：  JvmKillTest<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/16 0016 10:04
 */
public class JvmKillTest {
    /**
     * 只有在正常关闭时才会执行jvm hook，kill的方式不执行
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("use jvm shutdown hook");
        }));

        Timer timer = new Timer();

        Runnable runnable = () -> {

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("hahha");
                }
            },1000,2000);

        };

        new Thread(runnable).start();


        Thread.sleep(5000);
        timer.cancel();
    }
}
