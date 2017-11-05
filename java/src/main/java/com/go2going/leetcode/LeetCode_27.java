package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/11/5 18:01
 */
public class LeetCode_27 {
    /**
     * 举个例子就能看懂
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {

        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[length++] = nums[i];
            }
        }

        return length;
    }
}
