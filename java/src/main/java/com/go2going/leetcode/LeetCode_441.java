package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_441<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/6 0006 11:05
 */
public class LeetCode_441 {
    public int arrangeCoins(int n) {
        int sum = 0;
        while (n > 0) {
            int i = sum + 1;
            n = n - i;
            sum=i;
        }
        return n < 0 ? sum - 1 : sum;
    }
}
