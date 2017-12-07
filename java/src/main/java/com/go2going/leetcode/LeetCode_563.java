package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_563<br>
 * 描述：注意题目说的不是很清楚，根节点=|所有的左节点-所有的右节点|
 *
 * @author wangqiang
 * 创建时间：  2017/12/7 0007 14:28
 */
public class LeetCode_563 {
    int sum = 0;

    public int findTilt(TreeNode root) {

        go(root);

        return sum;
    }

    public int go(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = go(root.left);
        int right = go(root.right);
        sum += Math.abs(left - right);

        return left + right + root.val;

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
