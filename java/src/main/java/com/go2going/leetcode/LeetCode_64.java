package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_64<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/12 0012 11:10
 */
public class LeetCode_64 {

    int[][] msx;

    /**
     * 最短路径问题,DP,使用递归太慢,时间复杂度为2^(nm),但是使用记忆化递归，时间复杂度为mn
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        msx = new int[m][n];
        return get(grid, m - 1, n - 1);
    }

    private int get(int[][] grid, int curi, int curj) {
        if (curi == 0 && curj == 0) {
            return grid[0][0];
        }
        if (curi < 0 || curj < 0) {
            return Integer.MAX_VALUE;
        }
        if (msx[curi][curj] > 0) {
            return msx[curi][curj];
        }
        int temp = grid[curi][curj] + Math.min(get(grid, curi - 1, curj), get(grid, curi, curj - 1));
        return msx[curi][curj] = temp;
    }

    /**
     * 非递归的方式,使用原有的数组保存值
     *
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        //看第一列
        for (int i = 1; i <= m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        //看第一行
        for (int i = 1; i <= n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        //非0行，0列
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m][n];
    }

    public static void main(String[] args) {
        LeetCode_64 leetCode_64 = new LeetCode_64();

        int i = leetCode_64.minPathSum(new int[][]{
                {3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3},
                {0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2},
                {8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9},
                {1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7},
                {8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8},
                {4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9},
                {6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1},
                {8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3},
                {9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3},
                {0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8},
                {4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3},
                {2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3},
                {0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3},
                {0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5},
                {6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2},
                {7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0},
                {3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0},
                {5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}
        });
        System.out.println(i);
    }
}
