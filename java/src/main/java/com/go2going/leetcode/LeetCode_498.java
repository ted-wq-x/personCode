package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_498 {

    public static void main(String[] args) {
        LeetCode_498 leetCode_498=new LeetCode_498();
        System.out.println(Arrays.toString(leetCode_498.findDiagonalOrder(new int[][]{{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}})));
    }

    /**
     * 这个题目意思不大，虽然是medium
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;
        int[] ans = new int[m * n];
        int i = 0, j = 0;
        for (int k = 0; k < ans.length; k++) {
            ans[k] = matrix[i][j];
            //方向的判断，是看出来的规律
            if ((i + j) % 2 == 0) {
                //    up
                //先判断需要拐弯的
                if (j+1 == n) {
                    i++;
                } else if (i == 0) {
                    j++;
                } else {
                    i--;
                    j++;
                }

            } else {
                //    down
                //先判断需要拐弯的
                if (i+1 == m) {
                    j++;
                } else if (j == 0) {
                    i++;
                } else {
                    j--;i++;
                }
            }

        }
        return ans;
    }
}
