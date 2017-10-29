package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/10/29 16:31
 */
public class LeetCode_521 {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
