package com.go2going;


import com.go2going.lombok.Person;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.*;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CompletableFuture;


/**
 * 项目名称：  testcode<br>
 * 类名称：  OptionalTest<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/30 0030 17:03
 */
public class OptionalTest {

    public static void main(String[] args) {


    }


    public static void test1(){

        System.out.println(ComparisonChain.start().compare(new Person("wq", "hhh", 25), new Person("scc", "hdhs", 23)
                , Comparator.comparingInt(Person::getAge)).result());
    }

    public static void test2(){
        LoadingCache<String, Integer> build = CacheBuilder.newBuilder().build(new CacheLoader<String, Integer>() {
            @Override
            public Integer load(String key) throws Exception {
                return null;

            }
        });

    }
}
