package com.go2going.leetcode;

import java.util.*;

public class LeetCode_310 {
    /**
     * Floyd-Warshall o(N^3)
     * 我有优化，但是超时
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if (n == 1 ) {
            ans.add(0);
            return ans;
        }
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i],-1);
        }
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        for (int i = 0; i < n; i++) {
            graph[i][i] = 0;
        }



        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                //i到j和j到i是相同的 优化点
                for (int j = i+1; j < n; j++) {
                    if (graph[i][k] >= 0 && graph[k][j] >= 0) {
                        if (graph[i][j] < 0 || graph[i][j] > (graph[i][k] + graph[k][j])) {
                            graph[i][j] = (graph[i][k] + graph[k][j]);
                            graph[j][i] = graph[i][j];
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int tmp = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                tmp = Math.max(graph[i][j], tmp);
            }
            if (tmp == 0) {
                continue;
            }
            if (tmp < min) {
                min = tmp;
                ans.clear();
                ans.add(i);
            } else if (tmp == min) {
                ans.add(i);
            }
        }
        return ans;
    }
    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        //use set because of get and set faster than list
        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }



    public static void main(String[] args) {
        LeetCode_310 leetCode_310 = new LeetCode_310();
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        long l = System.currentTimeMillis();
        List<Integer> minHeightTrees = leetCode_310.findMinHeightTrees(4, edges);
        System.out.println(minHeightTrees);
        System.out.println(System.currentTimeMillis()-l);
    }
}
