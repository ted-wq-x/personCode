package com.go2going.leetcode;

import java.util.*;

public class LeetCode_853 {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> times = new HashMap<>();

        int length = position.length;

        for (int i = 0; i < length; i++) {
            times.put(position[i], (double) (target - position[i]) / speed[i]);
        }

        //小到大
        Arrays.sort(position);
        int sum = length;
        //time n^2
        for (int i = 0; i < length; i++) {
            for (int j =i+1; j < length; j++) {
                //che dui
                if (times.get(position[i]) <= times.get(position[j])) {
                    sum--;
                    break;
                }
            }
        }


        return sum;

    }
}
