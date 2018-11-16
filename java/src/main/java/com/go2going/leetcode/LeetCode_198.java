package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_198<br>
 * 描述：不能同时使用相邻的两个数字，求最大值
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 13:22
 */
public class LeetCode_198 {


    /**
     * 动态规划问题，还是比较简单的
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            int num = nums[i];
            int pre = nums[i - 1];
            //就这两种情况，取最大值
            dp[i + 1] = Math.max(dp[i - 2] + pre, dp[i - 1] + num);
        }

        return dp[length];
    }

    /**
     * 这个dp比前面那个dp更好理解
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            //就这两种情况，取最大值，转移方程
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1] );
        }

        return dp[length-1];
    }

    public static void main(String[] args) {
        LeetCode_198 leetCode_198 = new LeetCode_198();
        System.out.println(leetCode_198.rob(new int[]{1,2,9,1}));
        System.out.println(leetCode_198.rob2(new int[]{1,2,9,1}));
    }
}
