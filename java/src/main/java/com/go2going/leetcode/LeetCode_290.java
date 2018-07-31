package com.go2going.leetcode;

import java.util.*;

public class LeetCode_290 {
    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");

        char[] c = pattern.toCharArray();
        if (split.length != c.length) {
            return false;
        }
        Map<String, List<Integer>> map1 = new LinkedHashMap<>();

        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            List<Integer> list = map1.get(s);
            if (list == null) {
                list = new ArrayList<>();
                map1.put(s, list);
            }
            list.add(i);
        }


        Map<Character, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < c.length; i++) {
            char c1 = c[i];
            List<Integer> list = map.get(c1);
            if (list == null) {
                list = new ArrayList<>();
                map.put(c1, list);
            }
            list.add(i);
        }
        Iterator<List<Integer>> m = map.values().iterator();
        Iterator<List<Integer>> m1 = map1.values().iterator();
        while (m.hasNext()) {
            List<Integer> x = m.next();
            List<Integer> x1 = m1.next();

            if (x.size() != x1.size()) {
                return false;
            }

            for (int i = 0; i < x.size(); i++) {
                if (!x.get(i).equals(x1.get(i))) {
                    return false;
                }
            }
        }

        return true;


    }
}
