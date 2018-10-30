package com.go2going.leetcode;

public class LeetCode_931 {

    /**
     * medium dp
     * dp[i][j] = A[i][j] + min(dp[i+1][j-1],dp[i+1][j], dp[i+1][j+1])
     * @param A
     * @return
     */
    public int minFallingPathSum(int[][] A) {
        int height = A.length;
        int length = A[0].length;

        int[][] cache = new int[height][length];

        for (int i = 0; i < length; i++) {
            cache[height - 1][i] = A[height - 1][i];
        }


        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j < length; j++) {
                if (j == 0) {
                    cache[i][j] = A[i][j] + Math.min(cache[i + 1][j], cache[i + 1][j+1]);
                } else if (j == length - 1) {
                    cache[i][j] = A[i][j] + Math.min(cache[i + 1][j], cache[i + 1][j-1]);
                } else {
                    cache[i][j] = A[i][j] +  Math.min(cache[i + 1][j-1], Math.min(cache[i + 1][j], cache[i + 1][j+1]));
                }
            }
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (cache[0][i] < ans) {
                ans = cache[0][i];
            }
        }

        return ans;
    }
}
