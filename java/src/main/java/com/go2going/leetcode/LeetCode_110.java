package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_110<br>
 * 描述：对于这个问题，高度平衡二叉树被定义为一个二叉树，其中每个节点的两个子树的深度不会相差超过1。
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 20:08
 */
public class LeetCode_110 {
    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }
        return maxDeep(root) != -1;
    }

    /**
     * 这个也没问题，就是做的重复了
     *
     * @param left
     * @param right
     * @return
     */
    public boolean isOk(TreeNode left, TreeNode right) {
        int abs = Math.abs((maxDeep(left) - maxDeep(right)));
        if (abs > 1) {
            return false;
        }

        boolean lf = true;
        if (left != null) {
            lf = isOk(left.left, left.right);
        }
        if (!lf) {
            return false;
        }

        boolean ri = true;
        if (right != null) {
            ri = isOk(right.left, right.right);
        }
        return ri;
    }


    /**
     * 第一次写的时候没注意到节点的左右其实已经算出来了
     *
     * @param node
     * @return
     */
    public int maxDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDeep(node.left);
        int right = maxDeep(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
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
