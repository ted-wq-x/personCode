package com.go2going.leetcode;

import java.util.Arrays;

/**
 * @author BlueT
 * 2017/10/29 10:22
 */
public class LeetCode_455 {

    /**
     * 使用贪心算法
     *
     * @param g 小孩期望的cookie
     * @param s cookie
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int sum = 0;
        int length = s.length;

        int index = 0;
        for (int i = 0, j = index; i < g.length && j < length; j++) {
            if (g[i] <= s[j]) {
                i++;
                sum++;
            }
        }

        return sum;
    }


    /*
    *
    * Arrays.sort(g);
        Arrays.sort(s);

        int sum = 0;
        int length = s.length;

        int index = 0;

        //对两个for循环进行合并
        for (int aG : g) {
            for (int j = index; j < length; j++) {
                if (aG <= s[j]) {
                    index = j + 1;
                    sum++;
                    break;
                }
            }
        }

        return sum;
    *
    * */


}
