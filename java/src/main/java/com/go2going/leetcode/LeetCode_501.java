package com.go2going.leetcode;

import java.util.*;

/**
 * @author BlueT
 * 2017/11/29 22:45
 */
public class LeetCode_501 {

    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 13ms
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {

        List<Integer> temp = new ArrayList<>();
        get(root);
        int max = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer num = integerIntegerEntry.getValue();
            if (num == max) {
                temp.add(integerIntegerEntry.getKey());
            } else if (num > max) {
                max = num;
                temp = new ArrayList<>();
                temp.add(integerIntegerEntry.getKey());
            }

        }

        int[] m = new int[temp.size()];

        for (int i = 0; i < temp.size(); i++) {
            m[i] = temp.get(i);
        }
        return m;

    }


    public void get(TreeNode node) {
        if (node != null) {
            get(node.left);
            Integer integer = map.get(node.val);
            if (integer == null) {
                integer = 0;
            }
            map.put(node.val, integer + 1);
            get(node.right);

        }
    }

    //当前的数字
    Integer curNum = null;

    //当前数字的次数
    int index = 0;

    //list中数字出现的次数，也就是当前遍历的数字中出现的最多的次数
    int max = 0;

    List<Integer> list = new ArrayList<>();

    /**
     * 4ms，这种方式是使用前序遍历，leetcode测试通过，但是在右节点=更节点的值时，这种方法是错误的，
     * @param root
     * @return
     */
    public int[] findMode1(TreeNode root) {

        gets(root);

        int[] m = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            m[i] = list.get(i);
        }
        return m;

    }

    /**
     * 前序遍历，如果右节点不会等于根节点时，这种方式是真确的，思想是当
     * @param node
     */
    public void gets(TreeNode node) {

        if (node == null) {
            return;
        }

        gets(node.left);

        if (curNum == null) {
            curNum = node.val;
            index = 1;
            max = 1;
            list.add(curNum);
        } else {


            if (curNum == node.val) {
                index++;
                //只有在index大于2才进来
                if (index > max) {
                    list.clear();
                    list.add(curNum);
                    max = index;
                } else if (index == max) {
                    list.add(curNum);
                }
            } else {
                //数字变了
                curNum = node.val;
                index = 1;

                //防止出现max=1没有添加的情况
                if (max == 1) {
                    list.add(curNum);
                }
            }

        }

        gets(node.right);

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
