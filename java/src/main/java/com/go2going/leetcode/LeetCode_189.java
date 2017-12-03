package com.go2going.leetcode;

import java.util.Arrays;

/**
 * @author BlueT
 * 2017/12/3 21:50
 */
public class LeetCode_189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;//计算选哟反转的个数，不是很懂
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] ints, int start, int end) {
        while (start < end) {
            int temp = ints[start];
            ints[start] = ints[end];
            ints[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate1(int[] nums, int k) {
        k=k%nums.length;
        int[] part1= Arrays.copyOf(nums,nums.length-k);
        int[] part2=Arrays.copyOfRange(nums,nums.length-k,nums.length);
        System.arraycopy(part2,0,nums,0,part2.length);
        System.arraycopy(part1,0,nums,part2.length,part1.length);
    }
}
