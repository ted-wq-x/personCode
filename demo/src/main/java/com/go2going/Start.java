package com.go2going;

import com.go2going.config.MyConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Start<br>
 * 描述：自己测试使用的
 *
 * @author wangqiang
 * 创建时间：  2017/12/11 0011 17:08
 */
public class Start {
    public static void main(String[] args) {

        /**
         * 使用spring的ioc
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);
      /*  UserDao bean = applicationContext.getBean(UserDao.class);
        System.out.println(bean.getUserIdByName(new User("wsa")));
        System.out.println(bean.getUserIdByName(new User("wsa")));
        System.out.println(bean.getUserIdByName(new User("wsa1",12)));
        System.out.println(bean.getUserIdByName(new User("wsa1",12)));
        System.out.println(bean.getUserIdByName(new User("wsa1",22)));
        System.out.println(bean.getUserIdByName(new User("wsa1",22)));

        System.out.println("---------------------------------------------");
        System.out.println(bean.getUserIdByNameTest(new User("wsa2",22)));
        System.out.println(bean.getUserIdByNameTest(new User("wsa2",22)));
*/
     /*   ProductDao bean1 = applicationContext.getBean(ProductDao.class);
        System.out.println(bean1.findById(12));*/
    }
}
