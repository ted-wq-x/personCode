package com.go2going.leetcode;

public class LeetCode_941 {
    /**
     * easy
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        int length = A.length;
        if (length < 3) {
            return false;
        }


        if (A[1] <= A[0]) {
            return false;
        }
        boolean up=true;
        for (int i = 2; i < length; i++) {
            if (up) {
                if (A[i] > A[i - 1]) {
                    continue;
                } else if (A[i] == A[i - 1]) {
                    return false;
                } else {
                    up=false;
                }
            }else {
                if (A[i] < A[i - 1]) {
                    continue;
                }else {
                    return false;
                }
            }

        }

        return !up;
    }
}
