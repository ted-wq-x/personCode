package com.go2going.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;

import javax.annotation.Resource;

/**
 * 项目名称：  testcode<br>
 * 类名称：  BootWebConfig<br>
 * 描述：在使用@EnableWebMvc之后的自定义方法，能干的事情很多
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 17:03
 */
@Component
public class BootWebConfig extends WebMvcConfigurerAdapter {

    @Resource
    private BootInterceptor bootInterceptor;
    /**
     * 可以添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bootInterceptor).addPathPatterns("/**");
    }

    /**
     * 添加类型转换器
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //1.5.9RELEASE不能使用lambda，否则无法启动
        registry.addConverter(new Converter<String, Boolean>() {

            @Override
            public Boolean convert(String s) {
                if ("y".equals(s.toLowerCase())) {
                    return true;
                } else if ("n".equals(s.toLowerCase())) {
                    return false;
                }
                return null;
            }
        });
    }
}
