package com.go2going.jdk;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 项目名称：  testcode<br>
 * 类名称：  UsingExplicitReadWriteLocks<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/15 0015 13:03
 */
public class UsingExplicitReadWriteLocks {
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private String content = "hello everyone";

    public String showContent(){
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();

        try {
            return content;
        }finally {
            readLock.unlock();
        }
    }

    public void writeContent(String newValue) {
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        writeLock.lock();
        try {
            content = newValue;
        }finally {
            writeLock.unlock();
        }
    }


    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        UsingExplicitReadWriteLocks url = new UsingExplicitReadWriteLocks();


        // Writers - only if no writer is available
        for (int i = 0; i < 20; i++) {
            executor.execute(() -> {
                try {
                    // Delay readers to start
                    Thread.sleep(new Random().nextInt(10) * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                url.writeContent(UUID.randomUUID().toString());

            });
        }



        // Readers
        for (int i = 0; i < 30; i++) {
            executor.submit(() -> {
                try {
                    // Delay readers to start
                    Thread.sleep(new Random().nextInt(10) * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(url.showContent());
            });
        }


        executor.shutdown();
    }
}
