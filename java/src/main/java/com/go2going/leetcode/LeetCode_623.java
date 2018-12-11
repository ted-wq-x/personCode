package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.go2going.leetcode.Helper.TreeNode;

public class LeetCode_623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        d--;
        while (d > 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                TreeNode left = poll.left;
                if (left != null) {
                    queue.addLast(left);
                }
                TreeNode right = poll.right;
                if (right != null) {
                    queue.addLast(right);
                }

            }
            d--;
        }

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode poll = queue.poll();

            TreeNode left = poll.left;
            TreeNode new_l = new TreeNode(v);
            new_l.left = left;
            poll.left = new_l;

            TreeNode right = poll.right;
            TreeNode new_r = new TreeNode(v);
            new_r.right = right;
            poll.right = new_r;
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode treeNode = Helper.stringToTreeNode("[4,2,null,3,1]");
        LeetCode_623 leetCode_623=new LeetCode_623();
        TreeNode node = leetCode_623.addOneRow(treeNode, 1, 3);
        System.out.println(node);
    }
}
