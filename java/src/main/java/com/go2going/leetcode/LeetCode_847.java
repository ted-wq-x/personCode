package com.go2going.leetcode;

import java.util.ArrayDeque;

/**
 * hard
 */
public class LeetCode_847 {
    /**
     * 求顶点覆盖的最短路径
     * BFS
     *
     * https://www.youtube.com/watch?time_continue=39&v=Vo3OEN2xgwk
     *
     * @param graph
     * @return
     */
    public int shortestPathLength(int[][] graph) {
        int length = graph.length;

        //状态的表示使用bit，如length=3,111表示3个节点都遍历完成
        int done = (1 << length) - 1;
        //数组0=点，1=遍历的状态
        ArrayDeque<Integer[]> queue = new ArrayDeque<>();

        //初始化状态
        for (int i = 0; i < length; i++) {
            queue.add(new Integer[]{i, 1 << i});
        }

        //1表示访问过
        int[][] visited = new int[length][1 << length];

        int min = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer[] pop = queue.pop();
                int node = pop[0];
                int state = pop[1];
                //done的表示方式是亮点
                if (state == done) {
                    return min;
                }
                if (visited[node][state] == 1) {
                    continue;
                }
                //BFS
                for (int i : graph[node]) {
                    queue.addLast(new Integer[]{i, state | 1 << i});
                }
                visited[node][state] = 1;
            }
            min++;
        }

        return -1;
    }
}
