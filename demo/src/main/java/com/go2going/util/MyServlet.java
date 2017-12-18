package com.go2going.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目名称：  testcode<br>
 * 类名称：  MyServlet<br>
 * 描述：自定义
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 17:14
 */
@Slf4j
@WebServlet(urlPatterns = "/web", name = "myServlet")
public class MyServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        log.debug("BackKom ops init myServlet....");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getWriter().println("you have visit my Servlet");
    }

    @Override
    public void destroy() {
        log.debug("BackKom ops destroy myServlet");
    }
}
