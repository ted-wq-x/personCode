package com.go2going.leetcode;

public class LeetCode_896 {

    public boolean isMonotonic(int[] A) {
        boolean up = true, down = true;
        for (int i = 1; i < A.length; i++) {

            up &= A[i] >= A[i - 1];
            down &= A[i] <= A[i - 1];

        }
        return up||down;
    }
}
