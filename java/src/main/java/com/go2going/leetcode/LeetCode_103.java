package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_103<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/19 0019 16:36
 */
public class LeetCode_103 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 给定一个二叉树，返回其节点值的锯齿水平顺序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        go(root, 0, lists);
        //返回锯齿
        for (int i = 1; i < lists.size(); i+=2) {
            List<Integer> list = lists.get(i);
            int l = 0, r = list.size() - 1;
            while (l < r) {
                Integer temp = list.get(l);
                Integer integer = list.get(r);
                list.set(l++, integer);
                list.set(r--, temp);
            }
        }

        return lists;
    }


    /**
     * 和102差不多
     * @param node
     * @param index
     * @param lists
     */
    private void go(TreeNode node, int index, List<List<Integer>> lists) {
        if (node == null) {
            return;
        }

        if (lists.size() == index) {
            lists.add(new ArrayList<>());
        }

        lists.get(index).add(node.val);
        go(node.left, index + 1, lists);
        go(node.right, index + 1, lists);

    }
}
