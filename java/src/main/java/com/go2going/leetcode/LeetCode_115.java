package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_115 {

    static int sl,tl;
    static char[] sc, tc;
    static int[][] temp;

    /**
     * 18ms dp 自己想的
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        sl = s.length();
        if (sl == 0) {
            return 0;
        }
        tl = t.length();
        sc = s.toCharArray();
        tc = t.toCharArray();
        temp=new int[sl][tl];

        for (int i = 0; i < sl; i++) {
            Arrays.fill(temp[i], -1);
        }

        return go(0, 0);
    }

    private static int go(int ss,int ts) {

        if (temp[ss][ts] != -1) {
            return temp[ss][ts];
        }
        int count = 0;
        for (int i = ss; i < sl; i++) {
            if (sc[i] == tc[ts]) {
                if (ts == tl - 1) {
                    count++;
                } else {
                    if (i != sl - 1) {
                        count += go(i + 1, ts + 1);
                    }
                }

            }
        }
        temp[ss][ts] = count;

        return count;
    }

    public static void main(String[] args) {
        LeetCode_115 leetCode_115=new LeetCode_115();
        System.out.println(leetCode_115.numDistinct("babgbag", "bag"));
    }
}
