package com.go2going.leetcode;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_59<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/2 0002 13:56
 */
public class LeetCode_59 {

    /**
     * 生成矩阵，页没啥难度就是弯弯绕
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {

        int[][] ints = new int[n][];
        for (int i = 0; i < n; i++) {
            ints[i] = new int[n];
        }

        int length = (int) Math.pow(n, 2);

        char s = 'd';
        int x = 0, y = 0,index=1,start=1;
        for (int i = 1; i <= length; i++) {

            ints[x][y] = i;

            switch (s) {
                case 'd':
                    if (index < n) {
                        y++;
                        index++;
                        break;
                    } else {
                        s = 's';
                        index = start;
                    }

                case 's':
                    if (index < n) {
                        x++;
                        index++;
                        break;
                    } else {
                        s = 'a';
                        index = start;
                    }
                case 'a':
                    if (index < n) {
                        y--;
                        index++;
                        break;
                    } else {
                        s = 'w';
                        index = start;
                        n--;
                    }

                case 'w':
                    if (index < n) {
                        x--;
                        index++;
                        break;
                    } else {
                        s = 'd';
                        y++;
                        start++;
                        index = start;
                        break;
                    }
            }
        }

        return ints;
    }

    public static void main(String[] args) {
        LeetCode_59 leetCode_59 = new LeetCode_59();
        int[][] ints = leetCode_59.generateMatrix(1);
        System.out.println(Arrays.deepToString(ints));
    }
}
