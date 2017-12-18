package com.go2going.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 项目名称：  testcode<br>
 * 类名称：  AppListener<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 15:53
 */
@Slf4j
@Component
public class AppListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("BackKom onApplicationEvent time is {}",event.getTimestamp());
    }
}
