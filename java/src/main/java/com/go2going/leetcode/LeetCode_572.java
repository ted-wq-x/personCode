package com.go2going.leetcode;

import java.util.LinkedList;
import java.util.Queue;

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

    public static void main(String[] args) {
        LeetCode_572 leetCode_572 = new LeetCode_572();
        TreeNode left = leetCode_572.stringToTreeNode("[3,4,5,1,2,null,null,0]");
        TreeNode right = leetCode_572.stringToTreeNode("[4,1,2]");
        leetCode_572.isSubtree(left, right);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public  TreeNode stringToTreeNode(String input) {
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

}
