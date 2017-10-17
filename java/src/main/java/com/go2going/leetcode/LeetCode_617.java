package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_617<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/17 0017 20:47
 */
public class LeetCode_617 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    class Solution {

        //关注点还是单个treeNode,得学会递归的思想
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            TreeNode treeNode = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
            treeNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
            treeNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
            return treeNode;
        }

        public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
            //能进行下一次递归的前提是，有下个子节点，所有，一个为null，另一个就不为空
            if(t1==null)
                return t2;
            if(t2==null)
                return t1;
            //累加返回左右节点中的任何一个就行
            t2.val += t1.val;
            t2.left=mergeTrees(t1.left,t2.left);
            t2.right = mergeTrees(t1.right,t2.right);
            return t2;
        }
    }
}
