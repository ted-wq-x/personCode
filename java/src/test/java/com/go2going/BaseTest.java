package com.go2going;

import org.junit.Test;

/**
 * 项目名称：  testcode<br>
 * 类名称：  BaseTest<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/25 0025 13:25
 */
public class BaseTest {

    @Test
    public void main() {
        int a = 12;
        double d = 12.23d;
        //类型提升
        System.out.println(a==12?a:d);
    }
    @Test
    public void test(){
        String name = "wq";
        convert(name);
        //wq
        System.out.println(name);
    }

    private static void convert(String name) {
        name = name + "sss";
    }
}
