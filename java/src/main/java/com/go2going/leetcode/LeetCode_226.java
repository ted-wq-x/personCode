package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_226<br>
 * 描述：翻转二叉树
 *
 * @author wangqiang
 * 创建时间：  2017/11/1 0001 9:37
 */
public class LeetCode_226 {
    /**
     * 独立解决
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return reverse(root);
    }

    public TreeNode reverse(TreeNode node) {
        if (node.left != null) {
            node.left = reverse(node.left);
        }

        if (node.right != null) {
            node.right = reverse(node.right);
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        return node;
    }

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
