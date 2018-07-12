package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_781 {
    public int numRabbits(int[] answers) {

        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        for (Integer n : map.keySet()) {
            //同一个答案的兔子中最多有几种颜色
            int group = map.get(n) / (n + 1);
            //!=0表示有多组，但是group会少一组，所以得加上
            res += map.get(n) % (n + 1) != 0 ? (group + 1) * (n + 1) : group * (n + 1);
        }
        return res;
    }
}
