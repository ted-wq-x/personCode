package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_557<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/24 0024 13:37
 */
public class LeetCode_557 {
    public static String reverseWords(String s) {

        String[] split = s.split(" ");

        StringBuilder sb = new StringBuilder();
        int length = split.length;
        for (int i = 0; i < length; i++) {
            sb.append(  reverseString1(split[i]));
            if (i != length - 1) {
                sb.append(" ");
            }

        }

        return sb.toString();
    }

    public static String reverseString1(String s) {
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
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
