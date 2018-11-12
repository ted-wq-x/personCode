package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_940 {

    /**
     * 牛逼的思路
     * @param S
     * @return
     */
    public int distinctSubseqII(String S) {
        long end[] = new long[26], mod = (long)1e9 + 7;
        for (char c : S.toCharArray())
            end[c - 'a'] = Arrays.stream(end).sum()%mod + 1;
        return (int)(Arrays.stream(end).sum() % mod);
    }

    public static void main(String[] args) {
        LeetCode_940 leetCode_940=new LeetCode_940();
        System.out.println(leetCode_940.distinctSubseqII("abc"));
    }
}
