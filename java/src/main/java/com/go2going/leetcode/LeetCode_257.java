package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BlueT
 * 2017/11/26 17:42
 */
public class LeetCode_257 {
     List<String> list = new ArrayList<>();

    /**
     * 二叉树的叶子路径,16ms
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {

        getLeaf(root, new StringBuilder());
        return list;
    }

    public void getLeaf(TreeNode node,StringBuilder str) {
        if (node == null) {
            return;
        }
        str.append(node.val);
        boolean b1 = node.left != null;
        if (b1) {
            getLeaf(node.left, new StringBuilder(str).append("->"));
        }
        boolean b = node.right != null;
        if (b) {
            getLeaf(node.right, new StringBuilder(str).append("->"));
        }
        if (!b1 && !b) {
            list.add(str.toString());
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
