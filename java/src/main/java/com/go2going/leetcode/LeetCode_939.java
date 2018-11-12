package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_939 {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> x_map=new HashMap<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            List<Integer> list = x_map.computeIfAbsent(x, k -> new ArrayList<>());
            list.add(y);
            // x_map.put(x, list);
        }

        int ans = Integer.MAX_VALUE;
        //正方形的表示方式，使用两个点，表示对角点，这个很关键
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                //注意这，否则会是面积为0
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                if (x_map.get(p1[0]).contains(p2[1]) && x_map.get(p2[0]).contains(p1[1])) {
                    ans = Math.min(ans, Math.abs(p1[0] - p2[0]) * Math.abs(p1[1] - p2[1]));
                }

            }
        }
        return ans==Integer.MAX_VALUE?0:ans ;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_939().minAreaRect(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}}));
    }
}
