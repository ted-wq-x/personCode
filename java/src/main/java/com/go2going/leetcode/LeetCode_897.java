package com.go2going.leetcode;

import com.go2going.leetcode.Helper.TreeNode;
public class LeetCode_897 {

    private Helper.TreeNode pre;
    public Helper.TreeNode increasingBST(TreeNode root) {

        TreeNode node = new TreeNode(0);
        pre = node;

        go(root);

        return node.right;
    }

    private void go(TreeNode root) {
        if (root == null) {
            return ;
        }
        go(root.left);
        pre.right = root;
        pre = root;
        pre.left=null;//取消循环引用，否则toString()时会栈溢出
        go(root.right);

    }

    /*public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }*/

    public static void main(String[] args) {
        Helper.TreeNode treeNode = Helper.stringToTreeNode("[5,3,6,2,4,null,8,1,null,null,null,7,9]");

        LeetCode_897 leetCode_897=new LeetCode_897();

        leetCode_897.increasingBST(treeNode);
    }
}
