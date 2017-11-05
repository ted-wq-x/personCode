package com.go2going.lombok;

import lombok.extern.slf4j.Slf4j;

/**
 * 项目名称：  testcode
 * 类名称：  lombokTest
 * 描述：目前lombok不支持java9，所以去掉了关于lombok的例子
 *
 * @author wangqiang
 * 创建时间：  2017/9/22 0022 15:49
 */
@Slf4j
public class lombokTest {



    public  void say(){
    }


    public static void main(String[] args) {
        System.out.println(lombokTest.class.getModifiers());
    }
}
