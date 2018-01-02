package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_54<br>
 * 描述：顺时针
 *
 * @author wangqiang
 * 创建时间：  2017/12/29 0029 16:24
 */
public class LeetCode_54 {


    /**
     * 这种方式不是很好，使用边界进行判断比较快，这题不难只是有点弯弯绕
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int length;
        if (matrix == null || (length = matrix.length) == 0) {
            return list;
        }
        int height = matrix[0].length;

        int i = 0, j = 0, x = length, y = height;
        String cur = "d";//wsad
        boolean[][] ii = new boolean[length][height];
        while (true) {
            if (j < y && !ii[i][j]) {
                list.add(matrix[i][j]);
                ii[i][j] = true;
            } else {
                break;
            }


            switch (cur) {
                case "d":
                    j++;
                    if (j < y && !ii[i][j]) {
                        break;
                    } else {
                        j--;
                        cur = "s";
                    }
                case "s":
                    i++;
                    if (i < x && !ii[i][j]) {

                        break;
                    } else {
                        i--;
                        cur = "a";
                    }
                case "a":
                    j--;
                    if (j >= 0 && !ii[i][j]) {
                        break;
                    } else {
                        j++;
                        cur = "w";
                    }
                case "w":
                    i--;
                    if (i >= 0 && !ii[i][j]) {
                        break;
                    } else {
                        i++;
                        j++;
                        cur = "d";
                    }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode_54 leetCode_54 = new LeetCode_54();
        List<Integer> list = leetCode_54.spiralOrder(new int[][]{{1}});

        System.out.println(list);
    }


    /**
     * @param matrix
     * @param removeIndex
     * @return
     */
    void move(int[][] matrix, int removeIndex, List<Integer> list) {

    }

}
