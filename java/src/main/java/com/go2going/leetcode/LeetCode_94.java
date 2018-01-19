package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_94<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/19 0019 10:22
 */
public class LeetCode_94 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        go(list, root);

        return list;

    }

    /**
     * 递归，值得学习
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        //可以画个图，便于理解
        while (!stack.empty() && cur != null) {

            //从某一个节点出发找到其最底层的左节点
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;

        }
        return list;

    }

    private void go(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        go(list, node.left);
        list.add(node.val);
        go(list, node.right);
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
