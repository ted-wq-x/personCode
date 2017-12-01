package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/1 21:58
 */
public class LeetCode_7 {
    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            //取余数，也就是取每一位数
            sum = sum * 10 + x % 10;
            //剩下的数
            x = x / 10;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) sum;
    }


}
