package com.go2going.leetcode;

public class LeetCode_832 {
    /**
     * 想下就好
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int l = A.length;
        int h = A[0].length;

        int ll = (h + 1) / 2;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < ll; j++) {
                if (A[i][j] == A[i][h - j - 1]) {
                    //取反
                    if (A[i][j] == 1) {
                        A[i][j] = 0;
                        A[i][h - j - 1] = 0;
                    } else {
                        A[i][j] = 1;
                        A[i][h - j - 1] = 1;
                    }

                }
            }
        }

        return A;
    }
}
