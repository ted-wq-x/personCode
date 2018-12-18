package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_442 {
    /**
     * 48ms,no cache
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);
        int length = nums.length;
        if (length == 0) {
            return ans;
        }
        int pre = nums[0];
        for (int i = 1; i < length; i++) {
            if (pre == nums[i]) {
                ans.add(pre);
            } else {
                pre = nums[i];
            }
        }

        return ans;

    }

    /**
     * with cache
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int length = nums.length;
        boolean[] cache = new boolean[length + 1];
        for (int i = 0; i < length; i++) {
            if (cache[nums[i]]) {
                ans.add(nums[i]);
            }else {
                cache[nums[i]] = true;
            }
        }
        return ans;

    }
}
