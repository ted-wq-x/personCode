package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_114<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/22 0022 10:46
 */
public class LeetCode_114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 原地高平,在前序遍历的基础上 ，需要保留节点间的关系
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);

        //左节点，递归之后找到右边的叶子节点
        TreeNode temp = root.left;

        while (temp != null && temp.right != null) {
            temp = temp.right;
        }

        flatten(root.right);

        if (temp != null) {
            //将右节点放到左节点的叶子节点之后
            temp.right = root.right;
            root.right = root.left;
            root.left=null;
        }

    }

}
