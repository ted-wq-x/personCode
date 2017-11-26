package com.go2going.leetcode;

import java.util.*;

/**
 * @author BlueT
 * 2017/11/26 17:08
 */
public class LeetCode_350 {
    /**
     * AC解
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            map.merge(i, 1, (a, b) -> a + b);
        }

        for (int i : nums2) {
            Integer integer = map.get(i);
            if (integer != null&&integer>0) {
                map.put(i, integer-1);
                list.add(i);
            }
        }

        int[] ints = new int[list.size()];


        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
