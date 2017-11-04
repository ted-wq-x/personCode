package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BlueT
 * 2017/11/4 18:30
 */
public class LeetCode_530 {


    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        add(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int i1 = list.get(i) - list.get(i - 1);

            if (i1 < min) {
                min = i1;
            }
        }
        return min;
    }

    /**
     * 中序遍历，数据从小到大
     * @param node
     */
    public void add(TreeNode node) {
        if (node != null) {
            add(node.left);
            list.add(node.val);
            add(node.right);
        }

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
