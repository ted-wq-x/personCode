package com.go2going.leetcode;

public class LeetCode_965 {
    public boolean isUnivalTree(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isUnivalTree(root.left, root.val)&&isUnivalTree(root.right, root.val);
    }

    public boolean isUnivalTree(TreeNode root,int target) {

        if (root == null) {
            return true;
        }
        if (root.val == target) {
            return isUnivalTree(root.left, target)&&isUnivalTree(root.right, target);
        }
        return false;
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
