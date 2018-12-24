package com.go2going.leetcode;

import java.util.TreeMap;

public class LeetCode_962 {
    /**
     * TODO 715ms-->634ms 太长
     * @param A
     * @return
     */
    public int maxWidthRamp(int[] A) {
        int ans = 0;
        int length = A.length;
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < length-ans; i++) {
            if (A[i] >= value) {
                continue;
            }
            for (int j = length - 1; j >= ans; j--) {
                if (A[i] <= A[j]) {
                    ans = Math.max(j - i, ans);
                    value =Math.min( A[i],value);
                    break;
                }
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        LeetCode_962 leetCode_962=new LeetCode_962();
        System.out.println(leetCode_962.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }
}
