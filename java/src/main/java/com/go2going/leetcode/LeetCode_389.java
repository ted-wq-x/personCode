package com.go2going.leetcode;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_389<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/10 0010 20:35
 */
public class LeetCode_389 {


    /**
     * 使用异或操作，相同的两个数异或为0，所以最后留下的就是多的那个
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference1(String s, String t) {
        int length = s.length();
        char a = t.charAt(length);

        for (int i = 0; i < length; i++) {
            a ^= s.charAt(i);
            a ^= t.charAt(i);
        }

        return a;
    }

    public char findTheDifference2(String s, String t) {
        int length = t.length();

        for (int i = 0; i < length; i++) {
            String trim = t.replaceFirst(String.valueOf(t.charAt(i)), "");
            if (isSame(trim,s)) {
                return t.charAt(i);
            }
        }
        return ' ';
    }

    public boolean isSame(String s1, String s2) {

        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars1);
        return Arrays.toString(chars).equals(Arrays.toString(chars1));
    }
}
