package com.go2going.leetcode;

import java.util.Arrays;

/**
 * @author BlueT
 * 2017/12/1 22:04
 */
public class LeetCode_14 {

    /**
     * 题目说的不是很明白，查找的是数组中所有的字符串的公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length - 1].toCharArray();
        int length = b.length;
        for (int i = 0; i < a.length; i++) {
            if (length > i && b[i] == a[i]) {
                result.append(a[i]);
            } else {
                return result.toString();
            }
        }
        return result.toString();
    }
}
