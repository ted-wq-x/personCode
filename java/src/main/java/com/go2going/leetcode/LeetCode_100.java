package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/11/4 22:31
 */
public class LeetCode_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

      return   isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
