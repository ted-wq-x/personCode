package com.go2going.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 项目名称：  testcode<br>
 * 类名称：  MyListener<br>
 * 描述：查看注解了解使用
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 15:51
 */
@WebListener
@Slf4j
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("BackKom myListener init!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("BackKom myListener destroy!");
    }
}
