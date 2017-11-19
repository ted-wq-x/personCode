package com.go2going.leetcode;

/**
 * 91题的升级版本
 * @author BlueT
 * 2017/11/19 18:11
 */
public class LeetCode_639 {

    private static final int SIZE = 1000000007;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        long[] str = new long[]{1,one(s.charAt(0))};


        for (int i = 1; i < s.length(); i++) {
            char ft = s.charAt(i);
            char sd = s.charAt(i-1);
            long p = str[1] * one(ft) + str[0] * two(sd, ft);

            str[0] = str[1];
            str[1] = p % SIZE;
        }

        return (int) str[1];
    }

    private int one(char c) {
        if (c == '0') {
            return 0;
        } else if (c == '*') {
            return  9;
        } else {
            return  1;
        }
    }

    private int two(char c1,char c2) {
        if (c1 == '*' && c2 == '*') {
            return 15;
        }
        if (c1 == '*') {
            //值得<=26
            return (c2 >= '0' && c2 <= '6') ? 2 : 1;
        } else if (c2 == '*') {
            switch (c1) {
                case '1':
                    return 9;
                case '2':
                    return 6;
                default:
                    return 0;
            }
        } else {
            //两个都不是*
            int i = (c1 - '0') * 10 + (c2 - '0');

            //这里不是很理解
            return i >= 10 && i <= 26?1:0;
        }


    }
}
