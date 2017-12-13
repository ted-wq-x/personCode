package com.go2going;

import com.go2going.bean.Human;
import com.go2going.config.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Start<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/11 0011 17:08
 */
public class Start {
    public static void main(String[] args) {

        /**
         * 使用spring的ioc
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration.class);


    }
}
