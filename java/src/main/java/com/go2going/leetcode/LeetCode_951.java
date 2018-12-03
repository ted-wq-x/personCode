package com.go2going.leetcode;

public class LeetCode_951 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return null==root2;
        }
        if (root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean b = flipEquiv(root1.left, root2.left);
        if (!b) {
            b = flipEquiv(root1.left, root2.right);
            if (b) {
                return flipEquiv(root1.right, root2.left);
            }
            return false;
        } else {
            return flipEquiv(root1.right, root2.right);
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
