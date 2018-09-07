package com.go2going.leetcode;

import java.util.*;

public class LeetCode_886 {

    ///////////////////////////////////////////////////////////////////////////
    // dfs=74ms bfs=45ms
    ///////////////////////////////////////////////////////////////////////////

    private Map<Integer, List<Integer>> graph;

    /**
     * 当前节点颜色，初始化为0表示没有染色，1=red,-1=blue
     */
    private int[] pointColor;


    /**
     * graph 二分图，多连通分量，图染色，DFS/BFS O(V+E)
     * <p>
     * https://www.youtube.com/watch?time_continue=229&v=VlZiMD7Iby4
     * <p>
     * like 785
     *
     * @param N        <=2000
     * @param dislikes
     * @return
     */
    public boolean possibleBipartition(int N, int[][] dislikes) {

        graph = new HashMap<>(N);
        //建图
        for (int i = 0; i < dislikes.length; i++) {
            int[] dislike = dislikes[i];

            List<Integer> list = graph.get(dislike[0] - 1);
            if (list == null) {
                list = new ArrayList<>();
                graph.put(dislike[0] - 1, list);
            }
            list.add(dislike[1] - 1);


            List<Integer> newlist = graph.get(dislike[1] - 1);
            if (newlist == null) {
                newlist = new ArrayList<>();
                graph.put(dislike[1] - 1, newlist);
            }
            newlist.add(dislike[0] - 1);

        }

        pointColor = new int[N];

        Arrays.fill(pointColor, 0);


        for (int i = 0; i < N; i++) {
            if (pointColor[i] == 0 && !dfs(i, 1)) return false;
        }
        return true;
    }

    /**
     * 对点进行染色
     *
     * @param index
     * @param color 默认染red=1
     * @return 表示染色是否成功
     */
    private boolean dfs(int index, int color) {
        pointColor[index] = color;
        List<Integer> list = graph.get(index);
        if (list == null) {
            return true;
        }
        for (Integer integer : list) {
            int neighbor = pointColor[integer];
            if (neighbor == color) {
                return false;
            }
            if (neighbor == 0 && !dfs(integer, -color)) {
                return false;
            }
        }
        return true;
    }


    public boolean possibleBipartition1(int N, int[][] dislikes) {

        graph = new HashMap<>(N);
        //建图
        for (int i = 0; i < dislikes.length; i++) {
            int[] dislike = dislikes[i];

            List<Integer> list = graph.get(dislike[0] - 1);
            if (list == null) {
                list = new ArrayList<>();
                graph.put(dislike[0] - 1, list);
            }
            list.add(dislike[1] - 1);


            List<Integer> newlist = graph.get(dislike[1] - 1);
            if (newlist == null) {
                newlist = new ArrayList<>();
                graph.put(dislike[1] - 1, newlist);
            }
            newlist.add(dislike[0] - 1);

        }

        pointColor = new int[N];

        Arrays.fill(pointColor, 0);


        //bfs

        ArrayDeque<Integer> queue = new ArrayDeque<>();


        for (int i = 0; i < N; i++) {
            if (pointColor[i] != 0) continue;
            queue.push(i);
            pointColor[i] = 1;

            while (!queue.isEmpty()) {
                Integer pop = queue.pop();
                List<Integer> list = graph.get(pop);
                if (list == null) {
                    continue;
                }
                for (Integer neighbor : list) {
                    //颜色冲突
                    if (pointColor[neighbor] == pointColor[pop]) {
                        return false;
                    }
                    if (pointColor[neighbor] != 0) {
                        //染色过
                        continue;
                    }
                    pointColor[neighbor] = -pointColor[pop];
                    queue.push(neighbor);
                }
            }
        }
        return true;
    }
}
