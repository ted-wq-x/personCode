package com.go2going.leetcode;

import java.util.ArrayList;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_207<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/14 0014 16:38
 */
public class LeetCode_207 {

    /**
     * 课程安排，但是存在先修课程这个条件
     * 题目可以转换成图论中在有向图中，是否存在环。
     * 使用拓扑排序（DFS）
     * @param numCourses 课程个数
     * @param prerequisites 条件
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //0表示未访问，1表示正在访问,2表示已经访问过
        int[] visited = new int[numCourses];

        //创建图,每一门课程对于一个list存放约束
        ArrayList[] graph = new ArrayList[numCourses];

        //初始化数组
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        // 初始化课程约束
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }


        for (int i = 0; i < numCourses; i++) {
            if (!dfs(visited,graph,i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * dfs算法
     * @param visited
     * @param graph
     * @param course
     * @return 不含有环返回true，测试可以继续dfs
     */
    private boolean dfs(int[] visited,ArrayList[] graph ,int course){

        // 正在访问的，就是有环的
        if (visited[course]==1) {
            return false;
        }
        //减少重复
        if (visited[course]==2) {
            return true;
        }

        //标记为正在访问
        visited[course] = 1;

        ArrayList arrayList = graph[course];

        for (int i = 0; i < arrayList.size(); i++) {
            if (!dfs(visited,graph,(int)arrayList.get(i))) {
                return false;
            }
        }

        //标记为已访问过
        visited[course] = 2;

        return true;
    }


    /**
     * BFS 算法 TODO
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {


        return true;
    }

}
