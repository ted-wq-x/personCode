package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_73<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/11 0011 18:48
 */
public class LeetCode_73 {

    /**
     * 最简单的方案，使用了额外的存储空间
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int height = matrix.length;
        int length = matrix[0].length;
        boolean[][] bs = new boolean[height][length];

        for (int i = 0; i < height; i++) {
            boolean is = true;//减少行的设置次数
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] == 0) {
                    if (is) {
                        //行
                        for (int k = 0; k < length; k++) {
                            bs[i][k] = true;
                            is = false;
                        }
                    }
                    //列
                    for (int k = 0; k < height; k++) {
                        bs[k][j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (bs[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }


    }


    public void setZeroes1(int[][] matrix) {
        int height = matrix.length;
        int length = matrix[0].length;
        boolean[] h = new boolean[height];//hang
        boolean[] l = new boolean[length];//lie

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] == 0) {
                    l[j] = true;
                    h[i] = true;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            if (h[i]) {
                for (int j = 0; j < length; j++) {
                    matrix[i][j] = 0;
                }
            }

        }


        for (int i = 0; i < length; i++) {
            if (l[i]) {
                for (int j = 0; j < height; j++) {
                    matrix[j][i] = 0;
                }
            }

        }
    }

    /**
     *
     *
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int height = matrix.length;
        int length = matrix[0].length;
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new Integer[]{i, j});
                }
            }
        }

        for (Integer[] integers : list) {

            //行,lie固定
            for (int k = 0; k < length; k++) {
                matrix[integers[0]][k] = 0;
            }

            //列
            for (int k = 0; k < height; k++) {
                matrix[k][integers[1]] = 0;
            }
        }
    }


    /**
     * 最高效的，不适用额外的存储空间，使用第一行和第一列作为标记空间
     * 佩服
     * @param matrix
     */
    public void setZeroes3(int[][] matrix) {
        int height = matrix.length;
        int length = matrix[0].length;
        boolean lis0 = false;
        boolean his0 = false;
        //标记第一行和第一列，其行或者列本身是否需要被设置为0，也做标记
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] == 0) {
                    //还可以优化的点，可以单独进行遍历处理
                    if(i==0) his0 = true;
                    if(j==0) lis0 = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //处理排除第一行和第一例的数据
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        //处理第一行和第一列
        if (lis0) {
            for (int i = 0; i < height; i++) {
                matrix[i][0] = 0;
            }
        }

        if (his0) {
            for (int i = 0; i < length; i++) {
                matrix[0][i] = 0;
            }
        }

    }


    public static void main(String[] args) {
        LeetCode_73 leetCode_73 = new LeetCode_73();
        leetCode_73.setZeroes(new int[][]{{0, 11}});
    }

}
