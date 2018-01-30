package com.go2going;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  ForeachTest<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/17 0017 17:05
 */
public class ForeachTest {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("c");

        a.add("b");
//        remove3(a);
        remove1(a);
//        remove2(a);

    }

    private static void remove1(List<String> a) {
        for (int i = 0; i < a.size(); i++) {
            String next = a.get(i);
            if (next.equals("a")) {
                a.remove(i);
            } else {
                System.out.println(next);
            }
        }
    }

    private static void remove2(List<String> a) {
        Iterator<String> iterator = a.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("a")) {
                iterator.remove();
            } else {
                System.out.println(next);
            }
        }
    }


    private static void remove3(List<String> a) {
        for (String s : a) {
            if (s.equals("a")) {
                a.remove(s);
            } else {
                System.out.println(s);
            }
        }

    }
}
