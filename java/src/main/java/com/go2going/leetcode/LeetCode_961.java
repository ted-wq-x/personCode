package com.go2going.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_961 {
    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            if (set.contains(i)) {
                return i;
            } else {
                set.add(i);
            }
        }
        return -1;
    }
}
