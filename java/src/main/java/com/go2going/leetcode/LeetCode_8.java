package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/10 21:40
 */
public class LeetCode_8 {

    /**
     * 别人的答案,53ms
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();

        char[] chars = str.toCharArray();
        char firstChar = chars[0];
        //sign：1--》正数，0--》负数
        int sign = 1, start = 0, len = chars.length;
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            //不是数字
            char c = chars[i];
            if (!Character.isDigit(c))
                return (int) sum * sign;
            sum = sum * 10 + c - '0';
            //越界
            if (sum > Integer.MAX_VALUE && sign == 1)
                return Integer.MAX_VALUE;
            if ((-1) * sum < Integer.MIN_VALUE && sign == -1)
                return Integer.MIN_VALUE;
        }

        return (int) sum * sign;
    }
}
