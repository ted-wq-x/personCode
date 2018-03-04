package com.go2going;

import org.junit.Test;

/**
 * 项目名称：  testcode<br>
 * 类名称：  BaseTest<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/25 0025 13:25
 */
public class BaseTest {

    @Test
    public void main() {
        int a = 12;
        double d = 12.23d;
        //类型提升
        System.out.println(a == 12 ? a : d);
    }

    @Test
    public void test() {
        String name = "wq";
        convert(name);
        //wq
        System.out.println(name);
    }


    @Test
    public void testJoin() {

        Thread thread3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "我是t3");
            System.out.println("close t3");
        }, "t3");

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "我是t2");
            try {
                thread3.start();
                thread3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("close t2");
        }, "t2");


        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "我是t1");
            try {
                thread2.start();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("close t1");
        }, "t1");
        thread1.start();
    }

    private static void convert(String name) {
        name = name + "sss";
    }
}

class wsx implements Runnable {
    boolean flag;

    public wsx(boolean flag) {
        this.flag = flag;
    }

    static Object o1 = new Object();
    static Object o2 = new Object();//注意这里使用静态，不然的话每个对象都会有各自的存储空间，就会都有锁了

    @Override
    public void run() {
        if (flag) {
            while (true) {
                synchronized (o1) {
                    System.out.println("if 1");
                    synchronized (o2) {
                        System.out.println("if 2");
                    }
                }
            }
        } else {
            while (true) {
                synchronized (o2) {
                    System.out.println("else 1");
                    synchronized (o1) {
                        System.out.println("else 2");
                    }
                }
            }
        }
    }
}
class runn {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock1) {
                    System.out.println("t1 lock1");
                    synchronized (lock2) {
                        System.out.println("t1 lock2");
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock2) {
                    System.out.println("t2 lock1");
                    synchronized (lock1) {
                        System.out.println("t2 lock2");
                    }
                }
            }

        });
        t1.start();
        t2.start();
    }
}
