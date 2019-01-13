package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author BlueT
 * 2019/1/13 11:43
 */
public class LeetCode_973 {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans=new int[K][2];
        int length = points.length;
        TreeMap<Double, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < length; i++) {
            int[] point = points[i];
            double t = Math.sqrt((double) (point[0] * point[0]) + (double) (point[1] * point[1]));
            List<Integer> orDefault = map.getOrDefault(t, new ArrayList<>());
            orDefault.add(i);
            map.put(t, orDefault);
        }
        int index = 0;
        for (Map.Entry<Double, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            for (Integer integer : value) {
                ans[index++] = points[integer];
                if (index >= K) {
                    return ans;
                }
            }

        }
        return ans;
    }
}
