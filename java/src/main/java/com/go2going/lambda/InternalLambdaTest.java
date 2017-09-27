package com.go2going.lambda;



import com.go2going.lambda.model.Person;
import com.go2going.lambda.model.Teacher;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.*;

/**
 * java8自带的lambda学习<br>
 *     <p>java自身定义了很多的function，下面列出的是主要的几个，可以看下{@link java.util.function}</p>
 *
 */
public class InternalLambdaTest {
    public static void main(String[] args) {
//        predicateTest();
//        functionTest();
//        suppliersTest();
//        consumerTest();
        optionalTest();
    }

    /**
     * 断言的意思，返回boolean
     */
    static void  predicateTest(){
        Predicate<String> predicate = (s) -> s.length() > 2;
        boolean wq = predicate.negate().test("wq");//取反
        assert wq;
    }

    /**
     * 接受个参数，返回结果
     */
    static void functionTest(){
        Function<String, Integer> getInteger = f -> {
            assert f != null;
            return Integer.valueOf(f);
        };

        Function<String, String> doubles = f -> f + "2";

        //在运行lambda之前使用，先调用一次这个lambda，返回值还是Function
        Function<String, String> compose = doubles.compose(Function.identity());
        System.out.println(compose.apply("12"));//==122

        //在lambda之前添加个lambda-----compose()，当然还有之后的lambda-----andThen()
        Integer apply = getInteger.compose(f -> f + "2").apply("1");
        System.out.println(apply);//12

        assert apply == 12;
    }

    /**
     * 返回一个对象，不能有参数
     */
    static void suppliersTest(){
        Supplier<Teacher> supplier= Teacher::new;
        System.out.println(supplier.get());
    }

    /**
     * 消费者<br>
     * 接受一个对象，无返回值，执行某些操作，该操作有可能产生副作用
     */
    static void consumerTest(){
        Supplier<Teacher> supplier= ()-> new Teacher("ws",12);
        Teacher teacher = supplier.get();
        Consumer<Teacher> consumer=x->x.setName(x.getName()+",consumer");
        consumer.accept(teacher);
        System.out.println(teacher);
    }

    /**
     * 比较，就不说了很简单
     */
    static void comparatorTest(){
        Comparator<Person> comparator = Comparator.comparing(Person::getName);
        Person p1 = new Person("John", 12);
        Person p2 = new Person("Alice", 22);
        int compare = comparator.compare(p1, p2);
    }

    /**
     * Optional不是lambda,是一个避免空指针的容器
     */
    static void optionalTest(){
        Optional<String> optional = Optional.of("wq");
        optional.ifPresent((f)->System.out.println(f+",jjjj"));
    }
}
