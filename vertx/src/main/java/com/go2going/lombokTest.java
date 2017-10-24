package com.go2going;

import lombok.extern.java.Log;

import java.util.logging.Level;

/**
 * 项目名称：  testcode
 * 类名称：  lombokTest
 * 描述：目前lombok不支持java9，所以去掉了关于lombok的例子
 *
 * @author wangqiang
 * 创建时间：  2017/9/22 0022 15:49
 */
@Log
public class lombokTest {



    public  void say(){
        log.log(Level.INFO, "Hello");
    }


    public static void main(String[] args) {
        lombokTest test = new lombokTest();

        test.say();
    }
}
