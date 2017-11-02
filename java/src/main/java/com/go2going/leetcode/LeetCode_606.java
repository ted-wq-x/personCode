package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_606<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/2 0002 8:53
 */
public class LeetCode_606 {
    /**
     * 当右子树有值时，左节点没值，则左节点赋值为null---》()
     *
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        build(t, sb);

        return sb.toString();
    }

    public void build(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("");
            return;
        }

        sb.append(node.val);
        boolean left = node.left != null;
        boolean right = node.right != null;

        if (left || right) {
            sb.append("(");
            if (left) {
                build(node.left, sb);
            }
            sb.append(")");
        }

        if (right) {
            sb.append("(");
            build(node.right, sb);
            sb.append(")");
        }

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
