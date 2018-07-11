package com.go2going.leetcode;

/**
 * https://www.youtube.com/watch?v=q1zk8vZIDw0
 */
public class LeetCode_866 {


    /**
     * recursion
     *
     * 只要有了思路还是很好写的
     *
     * @param root
     * @return 返回最小的节点
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        if (root == null) {
            return null;
        }
        return go(root).node;

    }

    public Result go(TreeNode node) {


        Result left;
        if (node.left == null ) {
            left = new Result(0, node);
        } else {
            left = go(node.left);
        }

        Result right;

        if (node.right == null ) {
            right = new Result(0, node);
        } else {
            right = go(node.right);
        }

        if (left.deep == right.deep) {
            return new Result(left.deep + 1, node);
        } else if (left.deep > right.deep) {
            return new Result(left.deep + 1, left.node);
        } else {
            return new Result(right.deep + 1, right.node);
        }

    }

    public static void main(String[] args) {
        LeetCode_866 leetCode_866=new LeetCode_866();
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);left.right=new TreeNode(2);
        root.left= left;
        root.right=new TreeNode(3);
        TreeNode treeNode = leetCode_866.subtreeWithAllDeepest(root);
        System.out.println(treeNode.val);
    }

    /**
     * 保存递归的返回结果，node为想要的答案
     */
    private class Result {

        int deep;
        TreeNode node;
        public Result(int deep, TreeNode node) {
            this.deep = deep;
            this.node = node;
        }
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
