package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_70<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/13 0013 11:20
 */
public class LeetCode_70 {
    /**
     * 4ms
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    /**
     * 4ms
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if(n<=0)
            return 0;
        if(n == 1)
            return 1;
        int pre = 1;
        int cur = 2;
        for (int i = 2; i < n; i++) {
            int temp = cur;
            cur = cur + pre;
            pre = temp;
        }
        return cur;
    }
}
