package com.go2going.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_873 {
    static int[][] pp;

    private static int go(int[] A, int a1, int a2) {
        if (pp[a1][a2] != -1) {
            return pp[a1][a2];
        }
        for (int i = a2 + 1; i < A.length; i++) {
            int sum = A[a1] + A[a2];
            if (sum == A[i]) {
                int i1 = 1 + go(A, a2, i);
                pp[a1][a2] = i1;
                return i1;
            } else if (A[i] > sum) {
                break;
            }
        }
        pp[a1][a2] = 0;
        return 0;
    }

    /**
     * 最长的斐波那契子序列
     * <p>
     * 记忆化递归
     * 318ms
     *
     * @param A
     * @return
     */
    public static int lenLongestFibSubseq(int[] A) {

        int length = A.length;

        pp = new int[length][length];

        for (int i = 0; i < length; i++) {
            Arrays.fill(pp[i], -1);
        }

        int ans = 0;
        for (int i = 0; i < length - 2; i++) {
            // if (length - i <= ans) {
            //     break;
            // }
            for (int m = i + 1; m < length - 1; m++) {
                // if (length - i <= ans) {
                //     break;
                // }
                ans = Math.max(ans, go(A, i, m));
            }
        }
        if (ans != 0) {
            return ans + 2;
        }
        return ans;
    }


    /**
     * DP
     * <p>
     * transition
     * dp[j][k]=dp[i][j]+1
     * i<j<k,A[i]+A[j]=A[k]
     *
     * @param A
     * @return
     */
    public static int lenLongestFibSubseq1(int[] A) {

        int length = A.length;

        //key=value,value=index
        //用于快速查询值是否在A中
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            map.put(A[i], i);
        }

        int[][]  dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], 2);
        }


        int ans = 0;
        for (int j = 0; j < length; j++) {
            for (int k = j + 1; k < length; k++) {

                int ai = A[k] - A[j];
                //剪纸
                if (ai >= A[j]) {
                    break;
                }

                Integer i = map.get(ai);
                if (i == null) {
                    //没找到
                    continue;
                }

                //关键
                dp[j][k] = dp[i][j] + 1;
                ans = Math.max(ans, dp[j][k]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq1(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
