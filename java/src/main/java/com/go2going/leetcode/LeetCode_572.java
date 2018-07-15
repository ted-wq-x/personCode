package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_572<br>
 * 描述：自己想的中序遍历，比对子串的方式不对
 *
 * @author wangqiang
 * 创建时间：  2017/11/13 0013 13:07
 */
public class LeetCode_572 {

    /**
     * 从每个节点作为根节点比对
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null) {
            return false;
        }

        if (isSame(s, t)) {
            return true;
        }

        //关注点在这
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s,TreeNode t) {

        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }
        //当前的s==t
        return isSame(s.left, t.left) && isSame(s.right, t.right);
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
