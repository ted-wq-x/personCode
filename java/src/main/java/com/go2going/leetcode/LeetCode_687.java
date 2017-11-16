package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_687<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/16 0016 20:33
 */
public class LeetCode_687 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            go(root);

        }

        return max;
    }


    public int go(TreeNode node) {

        int left = node.left != null ? go(node.left):0;
        int right = node.right != null ? go(node.right) : 0;

        int r = node.right != null && node.val == node.right.val ? right + 1 : 0;
        int i = node.left != null && node.val == node.left.val ?  left+ 1 : 0;


        //以当前节点作为根节点，则左右子树相加，去最大值
        max = Math.max(max, i + r);

        //取单边最大值
        return Math.max(i, r);
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
