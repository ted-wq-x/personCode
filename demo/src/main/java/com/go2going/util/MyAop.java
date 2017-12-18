package com.go2going.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 项目名称：  testcode<br>
 * 类名称：  MyAop<br>
 * 描述：默认已经使用了@EnableAspectJAutoProxy，所以不需要添加这个注解了
 * 1、当我们需要使用CGLIB来实现AOP的时候，需要配置spring.aop.proxy-target-class=true，不然默认使用的是标准Java的实现。
 * 2、几个注解@Aspect，@Pointcut，@Before，@After，@AfterReturning，@Around，@AfterThrowing
 * 3、使用@Order可以定义aop的优先级，在切入点前的操作，按order的值由小到大执行，在切入点后的操作，按order的值由大到小执行
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 17:22
 */
@Component
@Aspect
@Slf4j
public class MyAop {


    @Pointcut("execution(public * com.go2going.util.MyServlet.service(..)) ")
    public void pointCut() {
    }


    @Around("pointCut()")
    public Object aroundExec(ProceedingJoinPoint joinPoint) {

        Object proceed = null;
        try {
            log.info("BackKom aop before...");
            proceed = joinPoint.proceed();
            log.info("BackKom aop after...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return proceed;
    }
}
