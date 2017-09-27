package com.go2going.java9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.entry;

/**
 * 项目名称：  testcode<br>
 * 类名称：  CollectionFactories<br>
 * 描述：集合类的工厂方法
 *
 * @author wangqiang
 * 创建时间：  2017/9/26 0026 15:23
 */
public class CollectionFactories {
    public static void main(String[] args) {
//        createCollection();
//        finalCollection();

    }

    /**
     * of()工厂方法
     */
    static void createCollection() {
        Map<String, Integer> one = Map.of("one", 1, "two", 2);

        Map<String, String> stringStringMap = Map.ofEntries(entry("wq", "王强"), entry("scc", "孙晨晨"));

        Stream.of(one.entrySet(), stringStringMap.entrySet()).map(CollectionFactories::collectionString).forEach
                (System.out::println);

    }

    static String collectionString(Collection<?> collection) {
        return collection.stream().map(Object::toString).collect(Collectors.joining(", ", "", "\n"));
    }


    /**
     * 工厂方法放回的是ImmutableCollections，所有抛异常
     */
    static void finalCollection(){
        addCollection(List.of("a", "b", "c"), "d");
    }

    /**
     * 添加元素
     * @param collection
     * @param t
     * @param <T>
     */
    static <T> void addCollection(Collection<T> collection, T t) {
        try {
            collection.add(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
