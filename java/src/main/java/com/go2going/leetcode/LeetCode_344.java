package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/10/15 19:10
 */
public class LeetCode_344 {
    public String reverseString(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverseString(right) + reverseString(left);
    }

    public static void main(String[] args) {
        LeetCode_344 leetCode_344 = new LeetCode_344();
        System.out.println(leetCode_344.reverseString("hello"));
    }
}
