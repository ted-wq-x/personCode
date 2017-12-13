package com.go2going.security;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Security<br>
 * 描述：java中的SecurityManager
 *
 * @author wangqiang
 * 创建时间：  2017/12/13 0013 10:25
 */
public class Security {
    public static void main(String[] args) {

        //AccessControlException,没有文件的读取权限
        //默认的安全策略文件，它位于%JAVA_HOME%/jre/lib/security目录下面的java.policy
        //添加自定义的策略文件，添加jvm参数 -Djava.security.policy=c:/protect.policy
        System.setSecurityManager(new SecurityManager());
        try {
            FileReader reader = new FileReader("E:\\test.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String s;
            while ((s = bufferedReader.readLine()) != null) {

                System.out.println(s);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
