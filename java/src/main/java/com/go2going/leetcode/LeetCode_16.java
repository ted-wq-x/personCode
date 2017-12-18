package com.go2going.leetcode;

import java.util.Arrays;

/**
 * @author BlueT
 * 2017/12/16 18:52
 */
public class LeetCode_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int dis = Integer.MAX_VALUE,sumNoAbs=0;
        int length = nums.length;

        //-2减少循环
        for (int i = 0; i < length-2; i++) {
            int a1 = nums[i];
            int start = i + 1, end = length-1;
            //头尾指针往中间靠拢
            while (start < end) {
                int temp = a1 + nums[start] + nums[end];
                int abs = Math.abs(temp - target);
                if (abs < dis) {
                    dis = abs;
                    sumNoAbs = temp;
                    continue;
                }

                if (abs == 0) {
                    return target;
                } else if (temp < target) {
                    start++;
                } else {
                    end--;
                }

            }
        }

        return sumNoAbs;
    }
}
