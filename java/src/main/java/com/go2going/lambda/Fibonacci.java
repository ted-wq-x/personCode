package com.go2going.lambda;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Fibonacci<br>
 * 描述：使用forkJoin计算斐波那契数
 *
 * @author wangqiang
 * 创建时间：  2017/9/26 0026 16:43
 */
public class Fibonacci extends RecursiveTask<Integer> {
    private int n;

    private final int[] results = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n < 2) {
            return internalComputer(n);
        }

        Fibonacci fibonacci = new Fibonacci(n - 1);
        Fibonacci fibonacci1 = new Fibonacci(n - 2);
        fibonacci.invoke();
        fibonacci1.invoke();
        return fibonacci1.join() + fibonacci.join();
    }


    private int internalComputer(int n) {
        return results[n];
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ForkJoinTask<Integer> fjt = new Fibonacci(20);
        ForkJoinPool fjpool = ForkJoinPool.commonPool(); //创建ForkJoinPool线程池
//        ForkJoinPool fjpool = new ForkJoinPool(); //创建ForkJoinPool线程池
        int result = fjpool.invoke(fjt);//将任务提交给ForkJoinPool线程池

        // do something
        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start);

    }


}
