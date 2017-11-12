package com.go2going.leetcode;

/**
 * dp
 * https://leetcode.com/problems/decode-ways/discuss/
 * @author BlueT
 * 2017/11/12 20:11
 */
public class LeetCode_91 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;//实现从2开始的for的铺垫
        dp[1] = s.charAt(0) == '0' ? 0 : 1;//dp从2开始算
        for (int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode_91 leetCode_91 = new LeetCode_91();

        System.out.println(leetCode_91.numDecodings("119"));
    }

}
