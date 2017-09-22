package com.go2going.lambda;

import java.util.function.Function;

/**
 * 项目名称：  testcode
 * 类名称：  lambdaTest
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/22 0022 9:29
 */
public class lambdaTest {


    public static void main(String[] args) {

    }

    /**
     * 默认的lambda
     */
    static void defaultLambda(){
        Runnable hello = () -> System.out.println("hello");
        hello.run();
    }

}




class Person {

    private String name="wq";

    public Person(String name) {
        this.name = name;
    }

    public void say(){

    }

    public String getName(){
        return name;
    }


    public String print(Function <Person,String> f){

       return f.apply(this);
    }
}