package com.go2going.lambda;

import org.junit.Test;

import java.net.ServerSocket;
import java.util.OptionalLong;
import java.util.concurrent.*;
import java.util.stream.LongStream;

import static org.junit.Assert.*;

/**
 * 测试加密
 */
public class PersonTest {

    public static final long[] LONGS = LongStream.rangeClosed(1, 1000).toArray();

    /**
     * forkJoin的线程数量默认为cpu可用核心数，注意在定义线程数量时，默认会将本身的线程放到池中<br>
     *     使用的算法主要有：分治法，工作量窃取算法，关于forkJoin的原理参考{@literal http://blog.dyngr.com/blog/2016/09/15/java-forkjoinpool-internals/}
     */
    @Test
    public void forkJoinTest() throws Exception {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new RecursiveTask<Long>() {
            //递归算法的实现，当然这个算法很简单，所以性能很差，参考该类的说明
            @Override
            protected Long compute() {
                return null;
            }
        });


    }
}