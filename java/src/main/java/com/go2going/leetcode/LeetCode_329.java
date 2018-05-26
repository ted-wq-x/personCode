package com.go2going.leetcode;

import java.util.*;

/**
 * <a href="https://www.youtube.com/watch?v=yKr4iyQnBpY">参考<a/>
 */
public class LeetCode_329 {

    /**
     * 记录从每个点出发的最大长度
     */
    private int[][] dp;

    /**
     * 记录原始数组
     */
    private int[][] matrix;

    /**
     * time,space:mn
     * DFS 16ms
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int length = matrix.length;
        int height = matrix[0].length;

        this.dp = new int[length][height];
        for (int i = 0; i < length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int max = 0;

        this.matrix = matrix;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }

        return max;
    }

    /**
     * dfs查找最大值
     *
     * @param i
     * @param j
     * @return
     */
    private int dfs(int i, int j) {
        //已经有值的情况
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int[] temp = {-1, 1, 0, 0};

        //默认长度是1
        dp[i][j] = 1;

        // 计算周边的四个位置
        for (int i1 = 0; i1 < 4; i1++) {
            // 自己找出的规律
            int tx = temp[i1] + i;
            int ty = temp[3 - i1] + j;

            //越界||不是递增的
            if (tx < 0 || ty < 0 || tx >= dp.length || ty >= dp[0].length || matrix[tx][ty] <= matrix[i][j]) {
                continue;
            }

            //当前长度1+四个位置的dfs值
            dp[i][j] = Math.max(dp[i][j], 1 + dfs(tx, ty));

        }


        return dp[i][j];
    }

    /**
     * 方法二 bottom-up 有问题
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int length = matrix.length;
        int height = matrix[0].length;

        int[][] dp = new int[length][height];
        for (int i = 0; i < length; i++) {
            //此处初初始化值为1
            Arrays.fill(dp[i], 1);
        }

        int max = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                list.add(new int[]{matrix[i][j], i, j});
            }
        }

        //逆序排序,该成从小到大是对的
        list.sort((o1, o2) -> o2[0] - o1[0]);

        int[] temp = {-1, 1, 0, 0};

        for (int[] ints : list) {
            int x = ints[1];
            int y = ints[2];
            for (int i = 0; i < 4; i++) {
                int tx = x + temp[i];
                int ty = y + temp[3 - i];
                if (tx < 0 || ty < 0 || tx >= length || ty >= height) {
                    continue;
                }

                if (matrix[x][y] <= matrix[tx][ty]) {
                    continue;
                }
                dp[x][y] = Math.max(dp[x][y], 1 + dp[tx][ty]);
            }
            max = Math.max(max, dp[x][y]);
        }


        return max;

    }

    public static void main(String[] args) {
        LeetCode_329 leetCode_329 = new LeetCode_329();
        System.out.println(leetCode_329.longestIncreasingPath1(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));

    }

}
