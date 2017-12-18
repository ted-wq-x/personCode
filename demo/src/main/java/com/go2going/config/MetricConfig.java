package com.go2going.config;

import com.codahale.metrics.*;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * 项目名称：  testcode<br>
 * 类名称：  MetricConfig<br>
 * 描述：name的名字随意，不重复就行，种类就5中，还有个Health Checks没写，这个需要单独的jar
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 16:37
 */
@Configuration
public class MetricConfig {

    @Bean
    public MetricRegistry metrics() {
        return new MetricRegistry();
    }



    //    -------------------Reporter需要手动开启，开启之后需要关闭--------------------------
    /**
     * Reporter 数据的展现位置,查看代码可大致分为5中类型
     *
     * @param metrics
     * @return
     */
    @Bean
    public ConsoleReporter consoleReporter(MetricRegistry metrics) {
        ConsoleReporter build = ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
//        build.start(1,TimeUnit.SECONDS);
        return build;
    }


    @Bean(destroyMethod = "close")
    public Slf4jReporter slf4jReporter(MetricRegistry metrics) {
        Slf4jReporter build = Slf4jReporter.forRegistry(metrics)
                .outputTo(LoggerFactory.getLogger("com.go2going"))
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        build.start(120,TimeUnit.SECONDS);
        return build;
    }

    @Bean(destroyMethod = "close")
    public JmxReporter jmxReporter(MetricRegistry metrics) {
        JmxReporter build = JmxReporter.forRegistry(metrics).build();
        build.start();
        return build;
    }

    //    -----------------------------------------------------

    /**
     * TPS 计算器
     *
     * @param metrics
     * @return
     */
    @Bean
    public Meter requestMeter(MetricRegistry metrics) {
        return metrics.meter("request");
    }

    /**
     * 直方图
     *
     * @param metrics
     * @return
     */
    @Bean
    public Histogram responseSizes(MetricRegistry metrics) {
        return metrics.histogram("response-sizes");
    }

    /**
     * 计数器
     *
     * @param metrics
     * @return
     */
    @Bean
    public Counter requestCount(MetricRegistry metrics) {
        return metrics.counter("requestCount");
    }

    /**
     * 计时器
     *
     * @param metrics
     * @return
     */
    @Bean(name = "MetricsTimer")
    public Timer responses(MetricRegistry metrics) {
        return metrics.timer("executeTime");
    }
}
