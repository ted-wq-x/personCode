package com.go2going.leetcode;


/**
 * medium
 */
public class LeetCode_576 {


    //x从左往右，y从右往左
    private static int[] xy = new int[]{1, 0, -1, 0};
    //保存遍历过的值；横坐标，纵坐标，剩余的步数
    private static int[][][] mac;

    /**
     * 12ms
     *  100% 哈哈哈，自己想出来的
     *
     * @param m
     * @param n
     * @param N max move
     * @param i index
     * @param j index
     * @return
     */
    public int findPaths(int m, int n, int N, int i, int j) {
        mac = new int[m][n][N];
        return go(i, j, m, n, N);
    }
    private static int go(int i, int j, int m, int n, int N) {
        if (i >= m || i < 0 || j >= n || j < 0) {
            return 1;
        }
        if (N <= 0) {
            return 0;
        }
        //N-1是偏移
        if (mac[i][j][N - 1] != 0) {
            //-1表示已经遍历过，但是值为0
            if (mac[i][j][N - 1] == -1) {
                return 0;
            }
            return mac[i][j][N - 1];
        }
        int s = 0;

        for (int i1 = 0; i1 < 4; i1++) {
            s = (s + go(xy[i1] + i, j + xy[3 - i1], m, n, N - 1)) % 1000000007;
        }

        mac[i][j][N - 1] = s == 0 ? -1 : s;
        return s;
    }


}
