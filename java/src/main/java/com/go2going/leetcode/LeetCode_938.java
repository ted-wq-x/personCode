package com.go2going.leetcode;

public class LeetCode_938 {


    public int rangeSumBST(TreeNode root, int L, int R) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        int val = root.val;
        if (val >= L && val <= R) {
            ans += val;
            ans += rangeSumBST(root.left, L, R);
            ans += rangeSumBST(root.right, L, R);
        } else if (val < L) {
            ans += rangeSumBST(root.right, L, R);
        } else {
            ans += rangeSumBST(root.left, L, R);
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
