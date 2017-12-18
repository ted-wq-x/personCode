package com.go2going.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 项目名称：  testcode<br>
 * 类名称：  MyFilter<br>
 * 描述：自定义过滤器,查看注解了解如何使用
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 17:12
 */
@Slf4j
@WebFilter
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        log.debug("BackKom doFilter lalala.....");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
