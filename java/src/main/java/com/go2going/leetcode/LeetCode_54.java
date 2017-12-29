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
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int length;
        if (matrix == null || (length=matrix.length) == 0) {
            return list;
        }
        int  height = matrix[0].length;

        int i = 0, j = 0,x=length,y=height;
        //起点
        int indexi=0,indexj=0;
        String cur = "d";//wsad
        boolean[][] ii = new boolean[length][height];
        boolean isOk = true;
        while (isOk) {
            if (!ii[i][j]) {
                list.add(matrix[i][j]);
                ii[i][j] = true;
            } else {
                break;
            }


            switch (cur) {
                case "d":
                    if (j < x - 1) {
                        j++;break;
                    } else {
                        cur = "s";
                    }
                case "s":
                    if (i < y - 1) {
                        i++;
                        break;
                    } else {
                        cur = "a";
                    }
                case "a":
                    if (j > indexj) {
                        j--;break;
                    } else {
                        cur = "w";
                    }
                case "w":
                    if (i > indexi+1) {
                        i--;break;
                    } else {
                        j++;
                        cur = "d";
                        y = y - 1;
                        indexi = indexi + 1;
                        indexj = indexj + 1;
                        x = x - 1;
                        if (y <= 0 || indexi <= 0 || indexj <= 0 || x <= 0) {
                            isOk = false;
                            break;
                        }
                    }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode_54 leetCode_54 = new LeetCode_54();
        List<Integer> list = leetCode_54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

        System.out.println(list);
    }


    /**
     * @param matrix
     * @param removeIndex
     * @return
     */
    void move(int[][] matrix, int removeIndex,List<Integer> list) {


    }

}
