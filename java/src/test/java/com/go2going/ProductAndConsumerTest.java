package com.go2going;

import org.junit.Test;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author BlueT
 * 2018/3/3 20:26
 */
public class ProductAndConsumerTest {

    @Test
    public void test1() throws InterruptedException {
//        IBlockingQueue<Integer> waitNotify = new WaitNotify<>(2);
        IBlockingQueue<Integer> waitNotify = new Queue<>();
//        IBlockingQueue<Integer> waitNotify = new Condition<>(2);

        CountDownLatch countDownLatch = new CountDownLatch(10);

        Runnable runnable = () -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + waitNotify.take());
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

        };
        Thread thread = new Thread(runnable, "t1");
        thread.start();
        Thread thread1 = new Thread(runnable, "t2");
        thread1.start();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    waitNotify.put(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        countDownLatch.await();
        thread.interrupt();thread1.interrupt();
        System.out.println("Close");
    }
}

interface IBlockingQueue<T>{
    void put(T data) throws InterruptedException;

    T take() throws InterruptedException;
}

/**
 * 第一种使用wait，notifyAll的方式,使用这两个方法前得获得对象的监视器，查看方法描述
 * @param <T>
 */
class WaitNotify<T> implements IBlockingQueue<T>{

    private int size;
    private final LinkedList<T> linkedList = new LinkedList<>();
    private final Object lock = new Object();

    public WaitNotify(int size) {
        this.size = size;
    }

    @Override
    public void put(T data) throws InterruptedException {
        synchronized (lock) {
            while (linkedList.size() > size) {
                lock.wait();
            }

            linkedList.addLast(data);
            lock.notifyAll();
        }
    }

    @Override
    public T take() throws InterruptedException {
        synchronized (lock) {
            while (linkedList.size() <= 0) {
                lock.wait();
            }

            T t = linkedList.removeFirst();

            lock.notifyAll();
            return t;
        }
    }
}


/**
 * lock相当于是synchronize，condition相当于是上面的object
 * @param <T>
 */
class Condition<T> implements IBlockingQueue<T>{

    private LinkedList<T> linkedList = new LinkedList<>();
    private final Lock lock = new ReentrantLock();

    private final java.util.concurrent.locks.Condition read = lock.newCondition();
    private final java.util.concurrent.locks.Condition write = lock.newCondition();

    private int size;

    public  Condition(int size){
        this.size = size;
    }


    @Override
    public void put(T data) throws InterruptedException {


        try {
            lock.lock();

            while (linkedList.size() >= size) {
                // 将释放锁lock
                write.await();
            }

            linkedList.addLast(data);
            // 唤醒读线程
            read.signalAll();
        } finally {
            lock.unlock();
        }



    }

    @Override
    public T take() throws InterruptedException {

        try {
            lock.lock();
            while (linkedList.size() == 0) {
                // 将释放锁lock
                read.await();
            }

            T first = linkedList.removeFirst();
            // 唤醒写线程
            write.signalAll();

            return first;
        }finally {
            lock.unlock();
        }
    }
}


class Queue<T> implements IBlockingQueue<T>{


    private LinkedBlockingQueue<T> queue = new LinkedBlockingQueue<>(2);


    @Override
    public void put(T data) throws InterruptedException {
        queue.put(data);
    }

    @Override
    public T take() throws InterruptedException {
        return queue.take();
    }
}
