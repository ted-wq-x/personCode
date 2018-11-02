package com.go2going.leetcode;
import  com.go2going.leetcode.Helper.TreeNode;
public class LeetCode_450 {


    public static void main(String[] args) {
        TreeNode treeNode = Helper.stringToTreeNode("[5,3,6,2,4,null,7]");
        LeetCode_450 leetCode_450=new LeetCode_450();
        TreeNode treeNode1 = leetCode_450.deleteNode(treeNode, 3);

        System.out.println(treeNode1);
    }

    /**
     * https://www.youtube.com/watch?v=00r9qf7lgAk
     * 解释的非常好，难点在于不同情况的分析
     *
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else{

            // =key的情况

            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode min = root.right;
                while (min.left != null) {
                    min = min.left;
                }
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }

        return root;
    }
}


