package com.go2going.leetcode;

public class LeetCode_477 {
    /**
     * 思路很好
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int length = nums.length;

        int count = 0;
        for (int i = 0; i < 32; i++) {
            int ps = 0;
            for (int num : nums) {
                ps += (num >> i) & 1;
            }
            count += ps * (length - ps);
        }

        return count;
    }

    public static void main(String[] args) {
        LeetCode_477 leetCode_477=new LeetCode_477();
        System.out.println(leetCode_477.totalHammingDistance(new int[]{6,1,8,6,8}));
    }
}
