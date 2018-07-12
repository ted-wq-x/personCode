package com.go2going.leetcode;

public class LeetCode_814 {
    /**
     * 删除全是0的子树
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 1 || root.left != null || root.right != null) {
            return root;
        } else {
            return null;
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
