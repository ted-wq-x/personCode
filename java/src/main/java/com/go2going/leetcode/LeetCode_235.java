package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_235<br>
 * 描述：
 * <p>
 * <p>
 * 给定一个二叉搜索树（BST），找出两个给定节点的最小公共祖先（LCA）。
 * 根据维基百科对于LCA的定义：“最小公共祖先的定义是对于两个节点v和s有一个最小的节点T，
 * 以至于v和s都是T的后代（其中我们允许节点是自身的后代）。”
 * _______6______
 * /              \
 * ___2__          ___8__
 * /      \        /      \
 * 0      _4       7       9
 * /  \
 * 3   5
 * 例如，对于节点2和8的最小公共祖先是节点6.
 * <p>
 * 另一个是2和4的LCA是2，因为根据LCA的定义，一个节点的是自身是后代。
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 13:40
 */
public class LeetCode_235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 有点意思啊，没想到
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int val = root.val;

        if (val > p.val && val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (val < p.val && val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }

    }


}
