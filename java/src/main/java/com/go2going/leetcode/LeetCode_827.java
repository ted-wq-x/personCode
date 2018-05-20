package com.go2going.leetcode;

import java.util.*;

/**
 * 参考:https://www.youtube.com/watch?v=KqkXZpRB1x8&t=0s&index=3&list=PLLuMmzMTgVK66JImslfqAJLovRAyQKAas
 */
public class LeetCode_827 {

    private int length;
    private int height;
    private int[][] grid;
    /**
     * 找到所有的岛屿,查看每个海洋的四周计算填充之后的岛屿面积,并用数字标识(1,0不能用)
     * DFS
     * time:n*n
     * space:n*n
     * 37ms
     *
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {
        this.length = grid.length;
        this.height = grid[0].length;
        this.grid = grid;

        //key=岛屿的id,value=岛屿的面积
        Map<Integer, Integer> map = new HashMap<>();
        //颜色0,表示面积为0
        map.put(0, 0);

        //标示0为海洋,1为初始的陆地标记,>1标示岛屿
        int color_id = 1;
        int maxSize = 0;

        //标记所有岛屿
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == 1) {
                    ++color_id ;
                    Integer area = getArea(i, j, color_id);
                    map.put(color_id, area);
                    //记录单个岛屿的最大值
                    maxSize = Math.max(maxSize, area);
                }
            }
        }

        //找0
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == 0) {
                    int area = 1;
                    //查找该位置四周的岛屿,用set是防止重复
                    Set<Integer> color = new HashSet<>(4);

                    color.add(getColor(i - 1, j));
                    color.add(getColor(i + 1, j));
                    color.add(getColor(i, j - 1));
                    color.add(getColor(i, j + 1));

                    for (Integer aColor : color) {
                        area += map.get(aColor);
                    }
                    maxSize = Math.max(maxSize, area);
                }
            }
        }

        return maxSize;
    }

    /**
     * 获取当前位置的颜色
     * @param i
     * @param j
     * @return
     */
    private int getColor(int i, int j) {
        if(i<0||i>=length||j<0||j>=height||grid[i][j]==1) return 0;
        return grid[i][j];
    }

    /**
     * 获取当前位置获得的岛屿的最大面积
     *
     * @param i length
     * @param j height
     * @param color_id 岛屿颜色标识
     * @return 岛屿面积
     */
    private Integer getArea(int i, int j, int color_id) {
        //越界或者不是1
        if(i<0||i>=length||j<0||j>=height||grid[i][j]!=1) return 0;

        //设置标示所属
        grid[i][j] = color_id;

        return 1 + getArea(i - 1, j, color_id) + getArea(i + 1, j, color_id)
                + getArea(i, j - 1, color_id) + getArea(i, j + 1, color_id);

    }

    public static void main(String[] args) {
        LeetCode_827 leetCode_827 = new LeetCode_827();
        int[][] ints = new int[2][];
        ints[0] = new int[]{1, 1};
        ints[1] = new int[]{1, 0};
        System.out.println(leetCode_827.largestIsland(ints));

    }
}
