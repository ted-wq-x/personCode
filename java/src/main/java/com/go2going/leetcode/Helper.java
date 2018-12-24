package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author BlueT
 * 2018/7/15 13:46
 */
public class Helper {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    /**
     * 参照这个描述：https://leetcode.com/contest/weekly-contest-91/problems/all-nodes-distance-k-in-binary-tree/
     * @param input [3,5,1,6,2,0,8,null,null,7,4]
     * @return
     */
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static int[][] StringToArray(String string) {
        String substring = string.substring(1, string.length() - 1);
        List<List<Integer>> ansL = new ArrayList<>();
        char[] chars = substring.toCharArray();
        List<Integer> temp=null;
        StringBuilder sb=new StringBuilder();
        for (char c : chars) {
            if (c == '[') {
                temp = new ArrayList<>();
            } else if (c == ']') {
                ansL.add(temp);
            } else if (c == ',') {
                if (sb.length() == 0) {
                    continue;
                }
                temp.add(Integer.valueOf(sb.toString()));
                sb=new StringBuilder();
            }else {
                //number
                sb.append(c);
            }
        }
        if (sb.length() != 0) {
            temp.add(Integer.valueOf(sb.toString()));
        }

        int size = ansL.size();
        int[][] ans = new int[size][];
        for (int i = 0; i < size; i++) {
            List<Integer> integers = ansL.get(i);
            ans[i] = new int[integers.size()];
            for (int j = 0; j < integers.size(); j++) {
                ans[i][j] = integers.get(j);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int[][] ints = StringToArray("[[0,2],[0,1],[3,3],[1,0],[2,3],[1,2],[1,333,4]]");
        System.out.println(ints.length);
    }
}
