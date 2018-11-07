package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_213 {
    public static void main(String[] args) {
        // System.out.println(new LeetCode_213().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new LeetCode_213().rob(new int[]{2,7,9,3,1}));
        // System.out.println(new LeetCode_213().rob(new int[]{2, 3, 2}));
        // System.out.println(new LeetCode_213().rob(new int[]{6, 6, 4, 8, 4, 3, 3, 10}));
        // System.out.println(new LeetCode_213().rob(new int[]{104, 209, 137, 52, 158, 67, 213, 86, 141, 110, 151, 127, 238, 147, 169, 138, 240, 185, 246, 225, 147, 203, 83, 83, 131, 227, 54, 78, 165, 180, 214, 151, 111, 161, 233, 147, 124, 143}));
    }

    /**
     * 6ms
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int ans = 0;

        int[] cache = new int[length + 2];

        Arrays.fill(cache, -1);

        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, nums[i] + go(nums, i+2, true, cache));
        }
        Arrays.fill(cache, -1);
        ans = Math.max(ans, nums[0] + go(nums, 2, false, cache));


        return ans;

    }

    private int go(int[] nums, int start, boolean canLast, int[] cache) {
        if (cache[start] != -1) {
            return cache[start];
        }
        int ans = 0;
        for (int i = start; i < nums.length; i++) {
            if (!canLast && i == nums.length - 1) {
                break;
            }
            ans = Math.max(ans, nums[i] + go(nums, i+2, canLast, cache));
        }
        cache[start] = ans;
        return ans;
    }
}
