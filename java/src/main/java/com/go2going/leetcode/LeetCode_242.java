package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/11/4 22:46
 */
public class LeetCode_242 {
    public boolean isAnagram(String s, String t) {
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i) - 'a']--;
        }


        for (int i = 0; i < 26; i++) {
            if (ints[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
