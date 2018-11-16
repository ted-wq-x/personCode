package com.go2going.leetcode;

public class LeetCode_740 {

    public static void main(String[] args) {
        LeetCode_740 leetCode_740=new LeetCode_740();
        System.out.println(leetCode_740.deleteAndEarn(new int[]{3, 4, 2}));
    }

    /**
     * 1. 如果拿走数p，那么所有的p都可以拿走（只需要将p-1和p+1都删掉）
     * 2. 如果拿了其他的p，那么p-1和p+1都不能拿
     * 将题目转化成了198题
     *
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums)
            values[num] += num;

        //198题的dp思路
        int dp1 = 0,dp2=0;

        for (int i = 0; i < values.length; i++) {
            int dp = Math.max(dp1, dp2 + values[i]);
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;

    }


}
