package com.go2going.leetcode;


/**
 * medium
 * 完全二叉树 https://blog.csdn.net/mawming/article/details/46471429
 */
public class LeetCode_222 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * O(n)
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root){
        return root == null ? 0 : 1 + countNodes1(root.left) + countNodes1(root.right);
    }

    /**
     * 判断是不是完美二叉树，不是就递归作为完全二叉树
     * 132 ms
     *
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root){

        if (root == null) {
            return 0;
        }

        TreeNode tl = root;
        int lh = 0,lr=0;

        while (tl != null) {
            lh++;
            tl = tl.left;
        }
        tl = root;
        while (tl != null) {
            lr++;
            tl = tl.right;
        }
        if (lh == lr) {
            return (1 << lh) - 1;
        }

        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }



    /**
     * 方法二左右两边的长度重复计算
     * 96ms
     * @param root
     * @return
     */
    public int countNodes3(TreeNode root){
        return getNum(root, -1, -1);
    }

    private static int getNum(TreeNode root, int l, int r) {
        if (root == null) {
            return 0;
        }

        TreeNode tl = root;
        int lh = 0,lr=0;

        if (l == -1) {
            while (tl != null) {
                lh++;
                tl = tl.left;
            }
        } else {
            lh = l - 1;
        }


        tl = root;
        if (r == -1) {
            while (tl != null) {
                lr++;
                tl = tl.right;
            }
        }else{
            lr = r - 1;
        }

        if (lh == lr) {
            return (1 << lh) - 1;
        }

        //这里是关键，记住这次的深度
        return 1 + getNum(root.left,lh,-1) + getNum(root.right,-1,lr);
    }




}
