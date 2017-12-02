package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/2 22:22
 */
public class LeetCode_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = minDepth(root.left);
        int j = minDepth(root.right);
        //找的是叶子节点，那么叶子节点的左右都为0，有一个为null的就不是叶子节点，那么就取不为0的值(
        // 等价于i+j+1)
        return (i == 0 || j == 0) ? i + j + 1 : Math.min(i, j) + 1;
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
