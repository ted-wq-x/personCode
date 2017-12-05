package com.go2going.jmx;

/**
 * 项目名称：  testcode<br>
 * 类名称：  IJmxTestBean<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/5 0005 11:08
 */
public interface IJmxTestBean {
    int getAge();

    void setAge(int age);

    void setName(String name);

    String getName();

    int add(int x, int y);

    void dontExposeMe();
}
