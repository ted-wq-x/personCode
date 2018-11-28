package com.go2going.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_945 {
    /**
     * 超时
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        Set<Integer> temp=new HashSet<>();
        int ans = 0;
        for (int i : A) {
            if (!temp.contains(i)) {
                temp.add(i);
            } else {
                int tt = 0;
                do {
                    tt++;
                }
                while (temp.contains(i + tt));
                temp.add(tt+i);
                ans += tt;
            }
        }
        return ans;
    }


    /**
     * 915ms
     * @param A
     * @return
     */
    public int minIncrementForUnique2(int[] A) {
        boolean[] temp = new boolean[40000];
        int ans = 0;
        int up = 40000;
        for (int i : A) {
            if (!temp[i]) {
                temp[i] = true;
            } else {
                int tt = 0;
                do {
                    tt++;
                }
                while (i+tt<40000&&temp[i + tt]);
                if (i + tt < 40000) {
                    temp[i + tt] = true;
                    ans += tt;
                } else {
                    ans += up - i;
                    up++;
                }
            }
        }
        return ans;
    }


    /**
     * 22ms,哈哈哈
     *
     * @param A
     * @return
     */
    public int minIncrementForUnique3(int[] A) {
        Arrays.sort(A);

        // up 记录当前的最大值
        int ans = 0, up = -1;

        for (int i : A) {
            if (i == up) {
                ans++;
                up++;
            } else if (up > i) {
                ans += up-i + 1;
                up++;
            } else {
                up=i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode_945 leetCode_945=new LeetCode_945();
        System.out.println(leetCode_945.minIncrementForUnique3(new int[]{39999,39999,39999}));
    }
}
