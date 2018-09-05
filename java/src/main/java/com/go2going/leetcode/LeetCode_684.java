package com.go2going.leetcode;

import com.go2going.leetcode.huahua.SP1;

/**
 * @author BlueT
 * 2018/8/14 23:25
 */
public class LeetCode_684 {
    /**
     * 题目的意思是有没有环，放在unionTree中就是存不存在a的根节点和a又相连了，也就是头右指向尾部。
     * 对这种算法不熟悉，很难将问题进行转换
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        SP1.UnionFindSet unionFindSet = new SP1.UnionFindSet(edges.length);
        for (int[] edge : edges) {
            if (!unionFindSet.union(edge[0], edge[1])) {
                return edge;
            }
        }

        return edges[edges.length - 1];
    }
}
