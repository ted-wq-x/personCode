package com.go2going.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 项目名称：  testcode<br>
 * 类名称：  MyInitializer<br>
 * 描述：@PostConstruct注解会调用这个切面
 *
 * @author wangqiang
 * 创建时间：  2017/12/11 0011 17:22
 */
public class MyInitializer implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return null;
    }
}
