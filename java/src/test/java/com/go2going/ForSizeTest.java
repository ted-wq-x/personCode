package com.go2going;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 项目名称：  testcode<br>
 * 类名称：  ForSizeTest<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/18 0018 8:47
 */
public class ForSizeTest {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        List<Integer> list = IntStream.range(1, 1000).boxed().collect(Collectors.toList());
//        int size = list.size();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
        }

        System.out.println(System.currentTimeMillis()-l);

    }
}
