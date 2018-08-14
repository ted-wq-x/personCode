package com.go2going.leetcode.huahua;

/**
 * https://www.youtube.com/watch?v=VJnUwsE4fWA
 * 算法 P144
 * @author BlueT
 * 2018/8/14 22:30
 */
public class SP1 {


    /**
     * Disjoint-set/Union-find Forest(并查集/联合查找)<br>
     * <a href="https://zh.wikipedia.org/wiki/%E5%B9%B6%E6%9F%A5%E9%9B%86">WIKI</a><br>
     * 既是数据结构也是算法<br>
     * find的优化time：O(n)->O(1):路径压缩、rank合并；space:O(n)<br>
     *
     * <a href="https://leetcode.com/problems/redundant-connection/">leetcode 684</a>
     * <a href="https://leetcode.com/problems/friend-circles/description/">leetcode 547</a>
     *
     * @param args
     */
    public static void main(String[] args) {

    }


    /**
     * 构成树状结构
     */
    public static class UnionFindSet{

        /**
         * 存放元素的根节点
         */
        private static int[] parents;
        /**
         * 树的高度
         */
        private static int[] rank;

        public UnionFindSet(int n) {
            parents = new int[n + 1];
            rank = new int[n + 1];

            // 初始化
            for (int i = 0; i < parents.length; ++i) {
                //初始化每个节点的值
                parents[i] = i;
                rank[i] = 1;
            }

        }

        /**
         * 理想情况下时间复杂度为1<br>
         * 查找元素u所在的子集（根节点）
         * @param u
         * @return
         */
        public int find(int u) {
            // 找到根节点
            while (u != parents[u]) {
                u = parents[u];
            }
            return u;
        }

        /**
         * 理想情况下时间复杂度为1<br>
         * 将两个子集合并成同一个集合
         * @param a
         * @param b
         * @return true:合并
         */
        public boolean union(int a, int b) {
            int af = find(a);
            int bf = find(b);
            // 根节点相同
            if (af == bf) {
                return false;
            }

            if (rank[af] > rank[bf]) {
                parents[bf] = af;
            } else if (rank[af] < rank[bf]) {
                parents[af] = bf;
            } else {
                parents[af] = bf;
                //注意rank的含义
                rank[bf]+=1;
            }

            return true;
        }
    }

}
