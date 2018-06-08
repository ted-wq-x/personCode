package com.go2going.leetcode;

/**
 * medium
 * 自己想的
 */
public class LeetCode_200 {


    //x从左往右，y从右往左
    private static  int[] xy = new int[]{1, 0, -1, 0};
    private static int length = 0, height = 0;

    //记录是否被访问过
    private static  int[][] code;


    public int numIslands(char[][] grid) {

        length = grid.length;
        if (length == 0) {
            return 0;
        }
        height = grid[0].length;

        code = new int[length][height];

        int sum = 0;


        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                //是1，并且当前位置没有被访问过
                if (grid[i][j] == '1'&&code[i][j] ==0) {
                    go(grid, i, j);
                    sum++;
                }
            }
        }

        return sum;
    }


    /**
     * 贪婪，遍历所有相连的1，进行标记
     * @param grid
     * @param x
     * @param y
     * @return 是否为水
     */
    private static void go(char[][] grid, int x, int y) {
        if (x >= length || x < 0 || y >= height || y < 0) {
            return ;
        }
        if (grid[x][y] == '0') {
            return ;
        }
        if (code[x][y] == 1) {
            return;
        }

        //标记为访问过
        code[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            go(grid,x+xy[i],y+xy[3-i]);
        }
    }
}
