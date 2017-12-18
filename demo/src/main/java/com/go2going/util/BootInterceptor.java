package com.go2going.util;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：  testcode<br>
 * 类名称：  BootInterceptor<br>
 * 描述：使用metrics进行统计,须有手动添加
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 16:24
 */
@Slf4j
@Component
public class BootInterceptor implements HandlerInterceptor {

    /**
     * 统计TPS
     */
    @Resource
    private Meter requestMeter;

    /**
     * 计数器
     */
    @Resource
    private Counter requestCount;

    /**
     * 计时器
     */
    @Autowired
    private Timer timer;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object
            o) throws Exception {
        requestMeter.mark();
        requestCount.inc();
        httpServletRequest.setAttribute("timer",timer.time());
        String ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = httpServletRequest.getRemoteAddr();
        }
        log.debug("BackKom preHandle request={} and handler={}", ipAddress, o);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        log.debug("BackKom postHandle...");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        Timer.Context timer = (Timer.Context) httpServletRequest.getAttribute("timer");
        long stop = timer.stop();
        log.debug("BackKom afterCompletion...,use time={}",stop);
    }
}
