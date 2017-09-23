package com.go2going.lambda;

import com.go2going.lambda.model.Person;

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
        defaultLambda();
    }

    /**
     * 默认的lambda
     */
    static void defaultLambda(){
        Runnable hello = () -> System.out.println("hello");
        hello.run();
    }

    static void personLambda() {
        Person person = Person.builder().name("ws").build();
        String print = person.print(p -> p.getName() + ",lambda");
        System.out.println(print);
    }

}


