package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_532<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/7 0007 15:03
 */
public class LeetCode_532 {
    /**
     * 不同的对
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {

        if (k < 0 || nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //差值为0，就是找相同的
                if (entry.getValue() >= 2) {
                    sum++;
                }
            } else {
                //只找比自己大的
                if (map.containsKey(entry.getKey() + k)) {
                    sum++;
                }
            }
        }

        return sum;
    }
}
