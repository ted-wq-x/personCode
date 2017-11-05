package com.go2going.leetcode;

import java.util.Arrays;

/**
 * @author BlueT
 * 2017/11/5 13:02
 */
public class LeetCode_217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int ind = 1; ind < nums.length; ind++) {
            if(nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }
}
