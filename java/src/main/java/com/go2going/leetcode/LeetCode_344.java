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

    /**
     * 这个比上面的更好，交换最前面和最后面的位置
     * @param s
     * @return
     */
    public String reverseString1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        int length = s.length()-1;
        int index = 0;
        while (index < length) {
            char a = chars[index];
            chars[index] =chars[length];
            chars[length] = a;
            index++;
            length--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        LeetCode_344 leetCode_344 = new LeetCode_344();
        System.out.println(leetCode_344.reverseString1("hello"));
    }
}
