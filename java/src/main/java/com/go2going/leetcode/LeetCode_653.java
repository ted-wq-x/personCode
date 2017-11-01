package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_653<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/1 0001 10:40
 */
public class LeetCode_653 {
    /**
     * 方法1：按照从小到大顺序获取树中的所有值，使用双指针逼近算法
     * 84.08%
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        find(root, list);
        int le = list.size();
        for (int i = 0, j = le - 1; i < j; ) {
            int sum = list.get(i) + list.get(j);
            if (sum== k) {
                return true;
            } else if (sum > k) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }


    /**
     * 方法1
     * @param root
     * @param list
     */
    public void find(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        find(root.left, list);
        list.add(root.val);
        find(root.right, list);
    }


    public boolean findOne(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        int val = root.val;
        if (val== k) {
            return true;
        } else if (val < k) {
            return findOne(root.right, k);
        } else {
            return findOne(root.left, k);
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
