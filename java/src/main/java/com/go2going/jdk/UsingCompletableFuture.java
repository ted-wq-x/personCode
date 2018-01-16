package com.go2going.jdk;

import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * 项目名称：  testcode<br>
 * 类名称：  UsingCompletableFuture<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/15 0015 13:01
 */
public class UsingCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random();

        //线程池非daemon线程，所以jvm不会关闭
        ExecutorService executorService = Executors.newCachedThreadPool();

        CompletableFuture<Integer> one = CompletableFuture.supplyAsync(() -> random.nextInt(10),
                executorService);

        //异步执行
        one.thenAcceptAsync(System.out::println);
        System.out.println("close 1");

        CompletableFuture<Integer> two = CompletableFuture.supplyAsync(() -> random.nextInt(140)
                , executorService);

        //使用了一个消费之
        two.thenAcceptBoth(one, (num1, num2) -> {
            System.out.println("num1 " + num1);
            System.out.println("num2 " + num2);
        });

        System.out.println("close 2");

        //组合

        CompletableFuture<Integer> three = one.thenCombine(two, (num1, num2) -> num1 + num2);
        System.out.println("three num is " + three.get());
        System.out.println("close 3");

        //带有延迟的任务

        Supplier<Double> dr = () -> {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return random.nextDouble();
        };

        CompletableFuture<Double> f1 = CompletableFuture.supplyAsync(dr);
        CompletableFuture<Double> f2 = CompletableFuture.supplyAsync(dr);
        CompletableFuture<Double> f3 = CompletableFuture.supplyAsync(dr);
        CompletableFuture<Double> f4 = CompletableFuture.supplyAsync(dr);

        CompletableFuture<Object> four = CompletableFuture.anyOf(f1, f2, f3, f4);
        System.out.println("four num is "+
                four.get());

        four.thenRun(() -> System.out.println("four close!"));

        Supplier<String> dr2 = () -> {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "second";
        };    Supplier<String> dr1 = () -> {
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "first";
        };

        CompletableFuture.supplyAsync(dr1).acceptEitherAsync(CompletableFuture.supplyAsync(dr2, executorService),
                System.out::println, executorService);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        //调用shutdown之后，最多等待多长时间
        executorService.awaitTermination(10000, TimeUnit.SECONDS);


    }
}
