package com.go2going.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Configuration<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/11 0011 17:04
 */
@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "com.go2going")
public class Configuration {

    @Bean
    MyInitializer initializer(){
        return new MyInitializer();
    }
}
