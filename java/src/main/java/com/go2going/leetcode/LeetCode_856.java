package com.go2going.leetcode;

public class LeetCode_856 {

    public static void main(String[] args) {
        LeetCode_856 leetCode_856 = new LeetCode_856();
        System.out.println(leetCode_856.scoreOfParentheses1("(()(()))"));
    }

    /**
     * 100% 递归
     *
     * @param S
     * @return
     */
    public int scoreOfParentheses(String S) {

        int length = S.length();
        if (length == 2) {
            return 1;
        }

        char[] c = S.toCharArray();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (c[i] == '(') {
                count++;
            } else {
                count--;
            }
            if (count == 0 && i != length - 1) {
                return scoreOfParentheses(S.substring(0, i + 1)) + scoreOfParentheses(S.substring(i + 1));
            }
        }
        return 2 * scoreOfParentheses(S.substring(1, c.length - 1));
    }


    /**
     * https://www.youtube.com/watch?v=tiAaVfMcL9w
     * 这种思路牛逼
     * counting
     * @param S
     * @return
     */
    public int scoreOfParentheses1(String S) {


        int length = S.length();
        int sum = 0,l=0;
        for (int i = 0; i < length; i++) {

            if (S.charAt(i) == '(') {
                l++;
            } else {
                --l;
                //i不可能为0
                if (S.charAt(i - 1) == '(') {
                    int i1 = 1 << l;
                    sum =sum+ i1;
                }
            }
        }

        return sum;
    }
}
