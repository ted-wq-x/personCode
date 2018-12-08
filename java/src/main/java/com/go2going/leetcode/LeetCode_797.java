package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_797 {
    // 6ms
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();

        //DFS

        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(graph, 0, temp,ans );

        return ans;
    }

    private void dfs(int[][] graph, int node, List<Integer> temp,  List<List<Integer>> ans) {
        int length = graph.length-1;
        int[] ints = graph[node];
        for (int i = 0; i < ints.length; i++) {
            int anInt = ints[i];
            if (anInt == length) {
                List<Integer> tt = new ArrayList<>(temp);
                tt.add(anInt);
                ans.add(tt);
            } else {
                int size = temp.size();
                temp.add(size, anInt);
                dfs(graph, anInt, temp, ans);
                temp.remove(size);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_797 leetCode_797=new LeetCode_797();

        List<List<Integer>> lists = leetCode_797.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});

        System.out.println(lists.size());
    }
}
