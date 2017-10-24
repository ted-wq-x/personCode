package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_463<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/24 0024 16:34
 */
public class LeetCode_463 {
    /**
     * 计算总的方块个数-重复的边
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        int hang = grid.length;
        int lie = grid[0].length;
        int sum1 = 0;
        int wait = 0;

        //统计单边，下面和右边
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                sum1++;
                if(j+1<lie&&grid[i][j+1]==1)   wait++;
                if(i+1<hang&&grid[i+1][j]==1)   wait++;
            }
        }

        return sum1 * 4 - wait *2;
    }


    public static void main(String[] args) {
//        int[][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid = new int[][]{{1},{1}};
        System.out.println(islandPerimeter(grid));
    }


}
