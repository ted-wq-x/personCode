package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode_970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        int i = bound / x;
        int j = bound / y;
        for (int m = 0; m <= i; m++) {
            for (int n = 0; n <= j; n++) {
                double v = Math.pow(x, m) + Math.pow(y, n);
                if (v <= bound) {
                    set.add((int) v);
                }else {
                    break;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
