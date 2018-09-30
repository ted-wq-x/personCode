package com.go2going.leetcode;

public class LeetCode_343 {
    /**
     * medium 100%
     * 自己想的，花了不少时间
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        // 题目提示的最小值为1
        int max = 1;
        // 将n分成i个数相加，如果当前乘积小于或等于前一个乘积就退出循环
        for (int i = 2; ; i++) {
            int i1 ;
            if (n % i == 0) {
                i1= (int) Math.pow(n / i,i);
            } else {
                // 将n分成i分，余数不为1时，将每一份都加1知道不够为止
                int i2 = n % i;
                // 如 8，分3份（2+2+2），余数为2，则变为（2+3+3）
                i1= (int) Math.pow(n / i,i-i2)*(int)Math.pow((n/i+1),i2);
            }

            if (i1 > max) {
                max = i1;
            } else {
                return max;
            }
        }

    }
}
