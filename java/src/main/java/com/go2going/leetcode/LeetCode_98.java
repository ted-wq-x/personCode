package com.go2going.leetcode;

/**
 * https://www.youtube.com/watch?v=Jq0Wk9xeQ0U
 *
 * @author BlueT
 * 2017/11/12 18:10
 */
public class LeetCode_98 {

    public boolean isValidBST(TreeNode root) {
        return isOk(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public boolean isOk(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val >= max || node.val <= min) {
            return false;
        }

        //判断值的范围min和max不会变
        return isOk(node.left,min, node.val) && isOk(node.right, node.val, max);

    }





    /**
     * 使用中序遍历，后面的比前面的大
     * @param node
     * @return
     */
    public boolean isOk1(TreeNode node) {
        if (node == null) {
            return true;
        }
        //false则结束，true继续执行
        if (!isOk1(node.left)) {
            return false;
        }

        if (pre != null && pre.val >= node.val) {
            return false;
        }
        pre = node;
        return isOk1(node.right);
    }

    TreeNode pre=null;

    public  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
