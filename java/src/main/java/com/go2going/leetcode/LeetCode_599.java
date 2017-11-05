package com.go2going.leetcode;

import java.util.*;

/**
 * @author BlueT
 * 2017/11/5 11:54
 */
public class LeetCode_599 {

    /**
     * 57.32%
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();
        int length1 = list1.length;
        int length2 = list2.length;

        //index和，和名称
        Map<Integer, List<String>> temp = new HashMap<>();
        for (int i = 0; i < length1; i++) {
            map.put(list1[i], i);
        }
        //记录最小的index
        int x = 2000;
        for (int i = 0; i < length2; i++) {
            String s = list2[i];
            Integer integer = map.get(s);
            if (integer != null) {
                int sum = integer + i;
                if (sum < x) {
                    x = sum;
                }
                List<String> strings = temp.get(sum);
                if (strings == null) {
                    strings = new ArrayList<>();
                    strings.add(s);
                    temp.put(sum, strings);
                } else {
                    strings.add(s);
                }
            }
        }
        List<String> strings = temp.get(x);
        String[] str = new String[strings.size()];
        return strings.toArray(str);

    }

    /**
     * 92%
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant1(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();//和上面的类似，记录最小值的list，存放名称
        int minSum = 2000;
        for (int i=0;i<list1.length;i++) map.put(list1[i], i);
        for (int i=0;i<list2.length;i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= minSum) {
                if (i + j < minSum) { res.clear(); minSum = i+j; }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }


    public static void main(String[] args) {
        LeetCode_599 leetCode_599 = new LeetCode_599();
        leetCode_599.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
    }
}
