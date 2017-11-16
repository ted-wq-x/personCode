package com.go2going.leetcode;

import java.util.*;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_107<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/15 0015 18:35
 */
public class LeetCode_107 {
    //比ArrayList性能要好，因为只有添加没有查找
    static List<List<Integer>> list = new LinkedList<>();


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        get(root, 0);

        return list;
    }

    public static void get(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        //不能使用get的方式是会数组越界
        if (list.size() <= level) {
            //使用index的方式插入，防止数组过大,且是倒序，和最后一行结合起来看
            list.add(level, new LinkedList<>());
        }

        get(node.left, level + 1);
        get(node.right, level + 1);

        //倒叙放置
        list.get(list.size() - level - 1).add(node.val);
    }


    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return list;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();//记住当前层的大小很重要
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < size; i++) {

                TreeNode peek = queue.peek();

                if (peek.left != null) {
                    queue.offer(peek.left);
                }

                if (peek.right != null) {
                    queue.offer(peek.right);
                }

                subList.add(queue.poll().val);
            }

            //确保是倒序
            list.add(0, subList);
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

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(0, 22);
        list.add(0, 23);
        System.out.println(list);
    }
}
