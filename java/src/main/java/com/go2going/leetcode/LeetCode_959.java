package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_959 {
    /**
     * 对这题，我是没啥思路，参考https://leetcode.com/problems/regions-cut-by-slashes/discuss/205674/C%2B%2B-with-picture-DFS-on-upscaled-grid
     * 将原来每个格子扩展成3x3的格子，这样斜线就使用格子表示
     * @param grid
     * @return
     */
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] cache = new boolean[3 * n][3 * n];
        //对cache进行填充
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '\\') {
                    cache[3*i][3*j]=true;
                    cache[3*i+1][3*j+1]=true;
                    cache[3*i+2][3*j+2]=true;
                } else if (grid[i].charAt(j) == '/') {
                    cache[3*i+2][3*j]=true;
                    cache[3*i+1][3*j+1]=true;
                    cache[3*i][3*j+2]=true;
                }
            }
        }
        int count = 0;
        //cache为true表示岩石，题目就转换成有多少片草地
        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                //false表示草地
                if (!cache[i][j]) {
                    count++;
                    dfs(cache, i,j);
                }
            }
        }

        return count;
    }

    private void dfs(boolean[][] cache, int i, int j) {
        if (i >= 0 && j >= 0 && i < cache.length && j < cache[0].length && !cache[i][j]) {
            cache[i][j]=true;
            dfs(cache, i-1,j);
            dfs(cache, i+1,j);
            dfs(cache, i,j-1);
            dfs(cache, i,j+1);
        }
    }

    public static void main(String[] args) {
        boolean[][] pp=new boolean[2][2];
        System.out.println(pp.length);
    }
}
