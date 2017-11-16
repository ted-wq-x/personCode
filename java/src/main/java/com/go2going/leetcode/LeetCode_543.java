package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_543<br>
 * 描述：这提做的很僵硬
 *
 * @author wangqiang
 * 创建时间：  2017/11/16 0016 18:26
 */
public class LeetCode_543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        go(root);

        return max;
    }

    public int go(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int left = 0;
        if (node.left != null) {
            left = go(node.left)+1;
        }
        int right = 0;
        if (node.right != null) {
            right = go(node.right)+1;
        }

        max= Math.max(max,left+right);
        return Math.max(right,left);

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
