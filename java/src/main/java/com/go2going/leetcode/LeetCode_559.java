package com.go2going.leetcode;

import java.util.List;

/**
 * @author BlueT
 * 2018/7/14 22:47
 */
public class LeetCode_559 {
    /**
     * easy
     * @param root
     * @return
     */
    public int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }

        List<Node> children = root.children;
        int sum = 0;
        for (Node child : children) {
            sum=Math.max(sum, maxDepth(child));
        }
        return sum+1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
