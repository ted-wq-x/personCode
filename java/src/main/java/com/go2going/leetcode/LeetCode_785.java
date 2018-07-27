package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_785 {
    /**
     * 二分图，染色法
     *
     * 对于每一个连通区来说，以某个节点为开始，默认将其涂成0，然后将它的neighbors涂成1，以此类推，直到节点全被涂完，或者颜色发生碰撞。
     *
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        //记录每个node的颜色
        int[] color = new int[length];

        Arrays.fill(color, -1);


        for (int i = 0; i < length; i++) {
            if (color[i] != -1) {
                continue;
            }

            if (isValid(color, i, 0, graph)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param color
     * @param i 染色的node
     * @param c 当前需要染色的颜色，0,1
     * @param graph
     * @return
     */
    private boolean isValid(int[] color, int i, int c, int[][] graph) {
        if (color[i] != -1) {
            //染过色了，判断颜色是否和被染的相同
            return color[i] != c;
        }

        //染色
        color[i] = c;

        //对临近节点染色
        for (int j : graph[i]) {
            if (isValid(color, j, 1 - c, graph)) {
                return true;
            }
        }

        return false;
    }
}
