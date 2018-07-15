package com.go2going.leetcode;

/**
 * easy
 * @author BlueT
 * 2018/7/15 16:12
 */
public class LeetCode_852 {
    public int peakIndexInMountainArray(int[] A) {
        int length = A.length;

        int index = 0;
        for (int i = 1; i < length; i++) {
            if (A[i] > A[index]) {
                index = i;
            } else {
                break;
            }
        }

        return index;

    }
}
