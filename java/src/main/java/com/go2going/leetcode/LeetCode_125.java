package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/3 16:08
 */
public class LeetCode_125 {
    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; ) {
            char a = chars[i];
            char b = chars[j];

            boolean letterOrDigit = Character.isLetterOrDigit(a);
            if (!letterOrDigit) {
                i++;
            }
            boolean letterOrDigit1 = Character.isLetterOrDigit(b);
            if (!letterOrDigit1) {
                j--;
            }

            //都是字母或者数字
            if (letterOrDigit && letterOrDigit1) {
                if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                    return false;
                }

                i++;
                j--;
            }
        }

        return true;
    }
}
