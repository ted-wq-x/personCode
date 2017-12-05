package com.go2going.jmx;

/**
 * 项目名称：  testcode<br>
 * 类名称：  JmxTestBean<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/5 0005 11:08
 */
public class JmxTestBean implements IJmxTestBean{

    private String name;
    private int age;
    private boolean isSuperman;

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public void dontExposeMe() {
        throw new RuntimeException();
    }
}
