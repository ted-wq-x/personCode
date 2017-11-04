package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/11/4 17:58
 */
public class LeetCode_404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sum(root,"");
        return sum;
    }


    /**
     *
     * @param node
     * @param s 标记当前节点对于父节点，是否为左节点
     */
    public void sum(TreeNode node,String s) {

        if (node.left == null && node.right == null&&s.equals("left")) {
            sum+= node.val;
            return;
        }

        if (node.left != null) {
            sum(node.left,"left");
        }
        if (node.right != null) {
            sum(node.right,"");
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
