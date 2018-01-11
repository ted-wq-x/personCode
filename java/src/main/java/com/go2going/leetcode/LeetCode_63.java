package com.go2going.leetcode;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_63<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/10 0010 19:06
 */
public class LeetCode_63 {

    /**
     * 62题的升级版本，数组中带有障碍物
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] ans = new int[m][n];

        return find(m - 1, n - 1, ans, obstacleGrid);
    }

    /**
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0].length == 0) return 1;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //上面的+左边的
                if (obstacleGrid[i - 1][j - 1] == 0) dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else dp[i][j] = 0;
            }
        }

        return dp[m][n];
    }

    private int find(int m, int n, int[][] ans, int[][] rou) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (rou[m][n] == 1) {
            ans[m][n] = 0;
            return 0;
        }

        if (m == 0 && n == 0) {
            return 1;
        }


        if (ans[m][n] != 0) {
            return ans[m][n];
        } else {
            ans[m][n] = find(m - 1, n, ans, rou) + find(m, n - 1, ans, rou);
        }
        return ans[m][n];
    }


    public static void main(String[] args) {
        LeetCode_63 leetCode_63 = new LeetCode_63();
        System.out.println(leetCode_63.uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 0}}));
    }
}
