package com.go2going.leetcode;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Main<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/10 0010 18:10
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("avd".getBytes()));
        LeetCode_389 code_389 = new LeetCode_389();
        System.out.println(code_389.findTheDifference("a", "aa"));
    }

    public static boolean isSame(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = s2.toCharArray();
        Arrays.sort(chars1);
        return chars==chars1;
    }
}
