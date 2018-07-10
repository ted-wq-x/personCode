package com.go2going.leetcode;

/**
 * ac
 */
public class LeetCode_840 {
    public int numMagicSquaresInside(int[][] grid) {

        int length = grid.length;
        if (length < 3) {
            return 0;
        }
        int height = grid[0].length;
        if (height < 3) {
            return 0;
        }


        int ans = 0;
        for (int i = 0; i < length-2; i++) {
            for (int j = 0; j < height - 2; j++) {
                if (!check(grid, i, j)) {
                    continue;
                }

                if (magic(grid, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }


    private boolean check(int[][] grid, int i, int j) {
        for (int k = 0; k < 3; k++) {
            for (int m = 0; m < 3; m++) {
                int val = grid[i + k][j + m];
                if (val >= 1 && val <= 9) {

                } else {
                    return false;
                }

            }
        }
        return true;
    }
    private boolean magic(int[][] grid, int i, int j) {

        int h1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        int h2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
        if (h1 != h2) {
            return false;
        }
        int h3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        if (h2 != h3) {
            return false;
        }
        int l1 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        if (l1 != h3) {
            return false;
        }
        int l2 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
        if (l1 != l2) {
            return false;
        }
        int l3 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
        if (l2 != l3) {
            return false;
        }

        int xy = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        if (l3 != xy) {
            return false;
        }
        int yx = grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2];
        if (xy != yx) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_840 leetCode_840 = new LeetCode_840();
        int i = leetCode_840.numMagicSquaresInside(new int[][]{{10, 3, 5}, {1, 6, 11}, {7, 9, 2}});

        System.out.println(i);
    }
}
