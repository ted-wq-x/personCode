package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_144<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/25 0025 16:30
 */
public class LeetCode_144 {
    /**
     * 前序遍历，递归方式
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        go(list,root);
        return list;
    }

    private void go(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        go(list, root.left);
        go(list, root.right);
    }

    /**
     * 迭代的方式
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return list;
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
