package com.go2going.leetcode;

public class LeetCode_701 {
    /**
     * 2ms
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode treeNode = new TreeNode(val);
        TreeNode ans = root;
        while (true) {
            if (root.val > val) {
                if (root.left == null) {
                    root.left = treeNode;
                    break;
                }
                root = root.left;
            } else {
                if (root.right == null) {
                    root.right = treeNode;
                    break;
                }
                root = root.right;
            }
        }
        return ans;
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
