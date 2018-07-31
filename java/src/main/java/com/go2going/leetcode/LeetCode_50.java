package com.go2going.leetcode;

public class LeetCode_50 {
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == Integer.MIN_VALUE) {

            return myPow(x, n + 1) / x;

        } else if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, n / 2);
        }
    }
}
