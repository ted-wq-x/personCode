package com.go2going.leetcode;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_48<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/28 0028 15:51
 */
public class LeetCode_48 {

    /**
     * 原地顺时针旋转矩阵，90度,关键是想到这种变换方式
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        int length = matrix.length;

        int i = 0, j = length - 1;
        while (i++ < j--) {
            for (int k = 0; k < length; k++) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = temp;
            }
        }

        for (int i1 = 0; i1 < length; i1++) {
            for (int k = i1; k < length; k++) {
                int temp = matrix[i1][k];
                matrix[i1][k] = matrix[k][i1];
                matrix[k][i1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_48 leetCode_48 = new LeetCode_48();
        int[][] ints = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        leetCode_48.rotate(ints);
        System.out.println(Arrays.deepToString(ints));
    }

}
