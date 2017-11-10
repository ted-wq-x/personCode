package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_437<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/9 0009 19:50
 */
public class LeetCode_437 {

    /**
     * dfs算法：把每个节点都作为根节点，向下遍历
     * 30ms
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        //实现从每个节点出发
        return search1(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }


    private int search1(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        return (node.val == sum ? 1 : 0)+search(left, sum - node.val)+search(right, sum - node.val);
    }

    Deque<TreeNode> list = new ArrayDeque<>();

    private boolean si = true;

    /**
     * 33ms
     * @param root
     * @param sum
     * @return
     */
    public int pathSum1(TreeNode root, int sum) {
        if (root == null) return 0;
        list.push(root);
        //实现从每个节点出发
        int c = 0;

        while (list.size() > 0) {
            c += search(list.removeFirst(), sum);
            si = false;
        }
        return c;
    }

    private int search(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }


        TreeNode left = node.left;
        TreeNode right = node.right;

        if (si) {
            if (left != null) {
                list.push(left);
            }
            if (right != null) {
                list.push(right);
            }
        }

        return (node.val == sum ? 1 : 0)+search(left, sum - node.val)+search(right, sum - node.val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        root.right = n2;
        n2.right = new TreeNode(3);
        LeetCode_437 leetCode_437 = new LeetCode_437();
        System.out.println(leetCode_437.pathSum1(root, 3));
    }
}

