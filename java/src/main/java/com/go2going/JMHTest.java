package com.go2going;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * 项目名称：  testcode<br>
 * 类名称：  JMHTest<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/8 0008 13:29
 */
public class JMHTest {

    private static final Logger logger = LoggerFactory.getLogger(JMHTest.class);
    @Benchmark
    public void concatenation(){

        String x = "", y = "", z = "";

        for (int i = 0; i < 100; i++) {
            x += i; y += i; z += i;

            logger.debug("Concatenating strings " + x + y + z);
        }
    }
    @Benchmark
    public void arguments(){

        String x = "", y = "", z = "";

        for (int i = 0; i < 100; i++) {
            x += i; y += i; z += i;

            logger.debug("Variable arguments {} {} {}", x, y, z);
        }
    }

    @Benchmark
    public void isDebugEnabled(){

        String x = "", y = "", z = "";

        for (int i = 0; i < 100; i++) {
            x += i; y += i; z += i;

            if (logger.isDebugEnabled())
                logger.debug("If debug enabled {} {} {}", x, y, z);
        }

    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().
                forks(1).
                include(JMHTest.class.getSimpleName()).
                timeUnit(TimeUnit.SECONDS).
                mode(Mode.Throughput).
                warmupIterations(5).//预热的迭代次数
                measurementIterations(10).//测试次数
                threads(5).//测试时的线程数
                build();

        new Runner(options).run();
    }
}
