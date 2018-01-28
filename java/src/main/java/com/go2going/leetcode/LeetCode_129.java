package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_129<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/23 0023 9:55
 */
public class LeetCode_129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return go(root, 0);
    }

    private int go(TreeNode node, int sum) {
        sum = node.val + sum * 10;
        int a = 0, b = 0;
        if (node.left != null) {
            a = go(node.left, sum);
        }
        if (node.right != null) {

            b = go(node.right, sum);
        }
        //左右节点都没有的话，返回当前节点的值
        if (a == 0 && b == 0) {
            return sum;
        }
        return a + b;
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
