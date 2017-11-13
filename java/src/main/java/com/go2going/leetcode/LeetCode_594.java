package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_594<br>
 * 描述：统计每种数字的个数，计算和他相邻的数字的个数和
 *
 * @author wangqiang
 * 创建时间：  2017/11/13 0013 13:52
 */
public class LeetCode_594 {
    public int findLHS(int[] nums) {

        Map<Long, Integer> map = new HashMap<>();

        for (long num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;

        for (Long aLong : map.keySet()) {
            if(map.containsKey(aLong+1)){
                max = Math.max(max, map.get(aLong) + map.get(aLong + 1));
            }
        }

        return max;
    }
}
