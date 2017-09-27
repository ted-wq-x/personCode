package com.go2going.lambda;

import com.go2going.lambda.model.Person;
import com.go2going.lambda.model.Teacher;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 项目名称：  testcode
 * 类名称：  lambdaTest
 * 描述：lambda可以参考{@link FunctionalInterface}上的注释，还有doc中的lambda.md
 *
 * @author wangqiang
 * 创建时间：  2017/9/22 0022 9:29
 */
public class lambdaTest {


    public static void main(String[] args) {
//        defaultLambda();
//        personLambda();
//        personCompare();
//        convertTest();
//        constructorQuotes();
        lambdaScope();
    }

    /**
     * 默认的lambda
     */
    static void defaultLambda() {
        Runnable hello = () -> System.out.println("hello");
        hello.run();
    }

    static void personLambda() {
//        Person person = Person.builder().name("ws").build();
//        String print = person.print(p -> p.getName() + ",lambda");
//        System.out.println(print);
    }


    static void personCompare() {
        List<Person> names = Arrays.asList(getRandomP(), getRandomP(), getRandomP(), getRandomP());
        names.sort(Comparator.comparing(Person::getAge));
        names.forEach(System.out::println);
    }

    static void convertTest(){
        //静态方法引用
        Converter<String,Integer> converter = Integer::valueOf;
        Integer convert = converter.convert("12");
        assert convert == 12;
    }

    static void methodQuotes(){
        //非静态方法引用，需要对象
        Something something = new Something();

        //看着很诡异，返回的是一个接口，函数方法的实现的入参和出参类型要一样
        Converter<String, String> sm = something::startWith;

        String wangqiang = sm.convert("wangqiang");

        assert wangqiang.equals("w");

    }

    static void constructorQuotes() {
        //构造器引用
        PersonFactory<Teacher> personPersonFactory = Teacher::new;
        //函数式接口，只能有一个抽象类，所以函数没有具体的行为，default方法也不行
        Teacher wa = personPersonFactory.create("wa", 25);
        System.out.println(wa);
    }

    static void lambdaScope(){
        int i = 12;
        Converter<Integer, Integer> sum = (from) -> {
            // lambda访问外部变量类似于匿名内部类，但是可以不使用final显示的表明为不可变属性，其实是不可变的，哈哈哈哈
            // 同时不能在内部改变i的值，因为默认为final啦！
            // but,对于实例变量有读写权限
            //            i = 22;
            return from + i;
        };

        System.out.println(sum.convert(12));
    }




    /**
     * 生成随机person
     */
    static Person getRandomP() {
        String random = RandomStringUtils.randomAlphabetic(5);
        Random random1 = new Random();
//        return Person.builder().name(random).age(random1.nextInt(100)).build();
        return null;
    }

    static class Something{
        String startWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }


}

/**
 * lambda对于成员变量都有读写权限
 */
class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
    }
}

