package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/2 20:54
 */
public class LeetCode_58 {
    public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}
