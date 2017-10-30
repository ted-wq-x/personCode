package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_695<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/30 0030 14:36
 */
public class LeetCode_695 {
    private int chang;
    private int kuan;

    /**
     * 自己想的，哈哈，性能还不错，思路是看某个点的上下左右是不是1，使用递归，之前使用队列性能很差，注意边界
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        chang = grid.length;
        kuan = grid[0].length;

        int sum = 0;

        for (int j = 0; j < kuan; j++) {
            for (int i = 0; i < chang; i++) {
                if (grid[i][j] == 1) {
                    int test = test(grid, i, j);
                    sum = Math.max(sum, test);
                }
            }

        }
        return sum;
    }

    public int test(int[][] grid, int i, int j) {
        int max = 1;
        grid[i][j] = 0;

        if (j + 1 < kuan && grid[i][j + 1] == 1) {
            max += test(grid, i, j + 1);
        }

        if (i + 1 < chang && grid[i + 1][j] == 1) {
            max += test(grid, i + 1, j);
        }

        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            max += test(grid, i - 1, j);
        }

        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            max += test(grid, i, j - 1);
        }

        return max;
    }


    public static void main(String[] args) {
        LeetCode_695 leetCode_695 = new LeetCode_695();
        System.out.println(leetCode_695.maxAreaOfIsland(new int[][]{{1, 1}, {0, 1}, {1, 1}}));

    }
}
