package com.go2going.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * medium 计算网络延迟，非常的贴近实际
 */
public class LeetCode_743 {

    /**
     * graph：single source all destinations shortest path
     * 1：dijkstra's algorithm
     * 2: bellman-ford
     * 3: floyd-warshall
     * <p>
     *
     * 求出从k出发到其他所有点的最短路径，找到最长的就是最大耗时
     * 求最短路径,3中方法都是模板
     *
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        //初始化数据结构，权值初始化为-1
        int[][] graph = new int[N + 1][N + 1];
        for (int[] row : graph) {
            Arrays.fill(row, -1);
        }

        //将原始数据，导入到graph中
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        //用于标记是否所有点都连同
        boolean[] visited = new boolean[N + 1];
        visited[0] = true;
        visited[K] = true;

        //保证每次poll都是权值最小的（贪婪）

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // 以K为起点，遍历所有节点，找到最长时间

        for (int i = 0; i <= N; i++) {
            if (graph[K][i] >= 0) {
                //i 为终点；权值
                pq.offer(new int[]{i, graph[K][i]});
            }
        }

        int max = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int target = cur[0];
            //访问过了
            if (visited[target]) {
                continue;
            }

            //权值的最大值
            // max = Math.max(max, cur[1]);
            max = cur[1];

            visited[cur[0]] = true;

            //遍历所有节点
            for (int i = 0; i <= N; i++) {
                if (graph[target][i] >= 0 && !visited[i]) {
                    pq.offer(new int[]{i, cur[1] + graph[target][i]});
                }
            }
        }

        for (boolean b : visited) {
            if (!b) {
                return -1;
            }
        }

        return max;

    }


    /**
     * bellman-ford:其核心思想是动态规划，从一点到另外一点的最短距离，有两种情况，1是两点距离就是最短，2是进过其他点
     *
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTime1(int[][] times, int N, int K) {
        int MAX_TIME = 101 * 100;

        //记录从k到所有其他点的最短距离
        int[] dis = new int[N + 1];

        Arrays.fill(dis, MAX_TIME);

        //从k到k的距离为0
        dis[K] = 0;
        dis[0] = -1;

        for (int i = 0; i < N; i++) {
            for (int[] time : times) {
                int u = time[0];
                int v = time[1];
                int w = time[2];

                //从K到v的最短距离，==》到u的最短距离+u到v的距离w
                dis[v] = Math.min(dis[v], dis[u] + w);
            }
        }
        int max = -1;
        for (int di : dis) {
            max = Math.max(di, max);
        }

        return max == MAX_TIME ? -1 : max;

    }

    /**
     * Floyd-Warshall
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTime2(int[][] times, int N, int K) {
        int[][] graph = new int[N][N];

        for (int[] g : graph) {
            Arrays.fill(g, -1);
        }

        for (int[] time : times) {
            graph[time[0]-1][time[1]-1] = time[2];
        }

        //起点和终点相同
        for (int i = 0; i < N; i++) {
            graph[i][i] = 0;
        }

        //i起点，j终点，k是中间点
        //k,i,j顺序不能乱
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] >= 0 && graph[k][j] >= 0) {
                        if (graph[i][j] < 0 || graph[i][j] > (graph[i][k] + graph[k][j])) {
                            graph[i][j] = (graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            int m = graph[K - 1][i];
            if (m < 0) {
                return -1;
            }
            max = Math.max(m, max);
        }

        return max;
    }

}
