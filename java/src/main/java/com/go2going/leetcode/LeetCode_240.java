package com.go2going.leetcode;

/**
 * medium
 */
public class LeetCode_240 {

    /**
     * great
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;

        if (length == 0) {
            return false;
        }

        int height = matrix[0].length;
        if (height == 0) {
            return false;
        }
        //从第一行的最后一个数开始比较
        for (int i = 0, j = height - 1; i < length && j >= 0; ) {
            int val = matrix[i][j];
            if (val == target) {
                return true;
            } else if (val < target) {
                //下移
                i++;
            } else {
                //左移
                j--;
            }

        }
        return false;
    }
}
