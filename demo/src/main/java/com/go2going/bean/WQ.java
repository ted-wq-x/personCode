package com.go2going.bean;

/**
 * 项目名称：  testcode<br>
 * 类名称：  WQ<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/12 0012 9:30
 */
public class WQ extends Human {
    private String name = "wq";
    private int age = 25;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "WQ{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
