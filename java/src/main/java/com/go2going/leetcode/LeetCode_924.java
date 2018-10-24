package com.go2going.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * hard:
 * https://buptwc.github.io/2018/10/15/Leetcode-924-Minimize-Malware-Spread/
 * 按照这个关键思路写的，但是实现没看，自己想的
 */
public class LeetCode_924 {
    public static void main(String[] args) {
        LeetCode_924 leetCode_924 = new LeetCode_924();
        System.out.println(leetCode_924.minMalwareSpread(new int[][]{
                        {1, 0, 0, 0, 1, 0, 0, 0},
                        {0, 1, 1, 0, 0, 1, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0, 0, 0},
                        {1, 0, 1, 1, 1, 0, 0, 1},
                        {0, 1, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 1, 0, 1, 1}
                }
                , new int[]{7, 2}));
    }

    /**
     * 89.38%
     * 分为2中情况
     * 1.如果连通图中有超过2个及以上的初始化感染节点，那么删除哪个都没用，所有的节点都会被感染
     * 2.如果连通图中只有1个初始化感染节点，那么删除这个节点，整个连通图都不会感染
     * 所以想要是被感染的点最少，就是找连通图中只有一个初始化感染节点的
     *
     * @param graph
     * @param initial
     * @return
     */
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int length = graph.length;
        int max = 0;
        int index = 0;
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < length; i++) {
            ans.add(i);
            int[] visited = new int[graph.length];
            dfs(graph, visited, i, ans);
            // 包含的初始化感染节点的个数
            int sum = 0;
            // 保存需要删除的感染节点
            int val = 0;
            for (int anInitial : initial) {
                if (ans.contains(anInitial)) {
                    sum++;
                    val = anInitial;
                }
            }
            if (sum == 1 && ans.size() > max) {
                max = ans.size();
                index = val;
            }
            // 这个剪枝很关键
            if (ans.size() == length) {
                break;
            }
            ans.clear();
        }
        if (max == 0) {
            //当没有一个点能够是其最小时，返回index最小的点
            Arrays.sort(initial);
            return initial[0];
        }
        return index;
    }

    /**
     * dfs获取以某点开始的连通图的所有点
     *
     * @param graph
     * @param visited
     * @param start
     * @param ans
     */
    private void dfs(int[][] graph, int[] visited, int start, Set<Integer> ans) {
        if (visited[start] == 1) {
            return;
        }
        int[] neighbor = graph[start];
        visited[start] = 1;
        for (int i = 0; i < neighbor.length; i++) {
            if (neighbor[i] == 1 && i != start) {
                ans.add(i);
                dfs(graph, visited, i, ans);
            }
        }
    }
}
