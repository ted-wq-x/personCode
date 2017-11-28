package com.go2going.leetcode;

import java.util.Stack;

/**
 * @author BlueT
 * 2017/11/28 22:32
 */
public class LeetCode_101 {

    /**
     * 使用递归
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        return root == null || isOk(root.left, root.right);
    }

    public boolean isOk(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }

        if (node1.val != node2.val) {
            return false;
        }
        return isOk(node1.left, node2.right) && isOk(node1.right, node2.left);

    }

    /**
     * 非递归
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {

            if (stack.size() % 2!=0) {
                return false;
            }

            TreeNode left = stack.pop();
            TreeNode right = stack.pop();
            if (!isSame(left, right)) {
                return false;
            }
            if (left == null && right == null) {
                continue;
            }

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }


    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        return left.val == right.val;
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
