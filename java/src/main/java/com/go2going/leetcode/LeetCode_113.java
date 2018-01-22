package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_113<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/22 0022 10:20
 */
public class LeetCode_113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root != null) {
            go(new ArrayList<>(), root, sum);
        }

        return lists;
    }

    private void go(List<Integer> list, TreeNode root, int sum) {

        list.add(root.val);
        int left = sum - root.val;
        //判断左右节点为空用于判断root节点是否为叶子节点
        if (left == 0 && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        if (root.left != null) {
            go(list, root.left, left);
        }

        if (root.right != null) {
            go(list, root.right, left);
        }

        list.remove(list.size() - 1);
    }
}
