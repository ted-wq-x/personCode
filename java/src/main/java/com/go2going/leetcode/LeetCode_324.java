package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LeetCode_324 {
    public static void main(String[] args) {
        LeetCode_324 leetCode_324 = new LeetCode_324();
        int[] nums = {1, 2, 3, 4, 5,6,7,8};
        leetCode_324.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     *
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int eIndex = length / 2 + length % 2;
        ArrayDeque<Integer> left=new ArrayDeque<>();
        ArrayDeque<Integer> right=new ArrayDeque<>();
        for (int i = 0; i <eIndex; i++) {
           left.addFirst(nums[i]);
        }
        for (int i = eIndex; i <length; i++) {
            right.addFirst(nums[i]);
        }
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                nums[i] = left.pop();
            } else {
                nums[i] = right.pop();
            }
        }
    }
}
