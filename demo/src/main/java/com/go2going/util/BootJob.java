package com.go2going.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 项目名称：  testcode<br>
 * 类名称：  BootJob<br>
 * 描述：定时任务
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 15:55
 */
@Component
@Slf4j
public class BootJob {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //100s一次
    @Scheduled(fixedRate = 100000)
    public void reportTime() {
        log.info("BackKom current time is:{} ", dateFormat.format(new Date()));
    }
}
