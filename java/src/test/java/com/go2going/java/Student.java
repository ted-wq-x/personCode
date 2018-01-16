package com.go2going.java;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Student<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/2 0002 20:36
 */
public class Student extends Person {

    private String grade;
    public Student(String name, int age) {
        super(name, age);
        this.grade = "22";
    }
}
