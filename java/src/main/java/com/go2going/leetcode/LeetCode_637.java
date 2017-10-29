package com.go2going.leetcode;

import java.util.*;

/**
 * 求二叉树的平均值
 * @author BlueT
 * 2017/10/29 16:40
 */
public class LeetCode_637 {
    /**
     * 按层遍历
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> list = new ArrayList<>();

        //存放下一层需要表里的节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            double sum = 0.0;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (poll.left != null) {
                    queue.add(poll.left);
                }

                if (poll.right != null) {
                    queue.add(poll.right);
                }
                sum += poll.val;

            }
            list.add(sum / size);

        }

        return list;
    }


    /**
     * 使用递归获取每一层的值，使用递归效率不高
     * @param root
     * @return
     */
    public List<Double> averageOfLevels1(TreeNode root) {

        List<Double> list = new ArrayList<>();


        //list中的顺序就是深度递增，数组0为size，1为和，类型分别为Integer, Double
        List<Object[]> maps = new ArrayList<>();
        rs(root, maps, 0);
        for (Object[] map : maps) {
            Integer size = (Integer) map[0];
            Double sum = (Double) map[1];
            list.add(sum / size);
        }


        return list;
    }

    /**
     * 前序
     * @param treeNode
     * @param map
     * @param i
     */
    public void rs(TreeNode treeNode,List<Object[]> map,int i) {
        if (treeNode == null) {
            return;
        }

        if (i >= map.size()) {
            //由于类型丢失，所以得加上初始值
            map.add(i,new Object[]{0,0.0});
        }

        Object[] index = map.get(i);

        Integer ls = (Integer) index[0];
        Double db = (Double) index[1];
        ls=ls+1;
        db += treeNode.val;
        index[0] = ls;
        index[1] = db;
        map.set(i, index);


        if (treeNode.left != null) {
            rs(treeNode.left,map,i+1);
        }

        if (treeNode.right != null) {
            rs(treeNode.right,map,i+1);
        }
    }

    /**
     * node
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



}
