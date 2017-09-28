package com.go2going;

import com.go2going.lambda.model.Person;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 项目名称：  testcode<br>
 * 类名称：  DefaultInterface<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/27 0027 11:24
 */
public interface DefaultInterface {

    /**
     * 默认方法
     */
    default void say() {
        System.out.println("hello");

        Runnable runnable = () -> {
            Person person = new Person();
        };
    }

    /**
     * 静态方法
     */
    static void hello() {
        System.out.println("world");
    }

    public static void main(String[] args) {

        List<Person> tasks = getTasks();
        Stream<Person> stream = tasks.stream();
        List<String> titles = taskTitles(stream, person -> person.getType() == 1, Person::getName);
        titles.forEach(System.out::println);
    }

    static List<Person> getTasks() {
        List<Person> of = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person(RandomStringUtils.randomAlphanumeric(5));
            of.add(person);
        }
        return of;
    }

    static <T> List<T> taskTitles(Stream<Person> tasks, Predicate<Person> filter, Function<Person, T> core) {
        return tasks.filter(filter).map(core).collect(Collectors.toList());
    }

    static <T> List<T> taskTitles(List<Person> tasks, Predicate<Person> filter, Function<Person, T> core) {
        List<T> readingTitles = new ArrayList<>();

        for (Person task : tasks) {
            if (filter.test(task)) {
                readingTitles.add(core.apply(task));
            }
        }
        return readingTitles;
    }

}
