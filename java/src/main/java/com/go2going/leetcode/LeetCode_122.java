package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_122<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/3 0003 9:38
 */
public class LeetCode_122 {
    public int maxProfit(int[] prices) {

        int sum = 0;

        for (int i = 1; i < prices.length; i++) {
            int i1 = prices[i] - prices[i - 1];
            if (i1 > 0) {
                sum += i1;
            }
        }

        return sum;
    }
}
