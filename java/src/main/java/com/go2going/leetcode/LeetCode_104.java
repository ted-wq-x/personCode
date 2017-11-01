package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_104<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/1 0001 9:21
 */
public class LeetCode_104 {

    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;
        else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    /**
     * 独立解决 感觉这个应该比上面的快点，也许是错觉
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return findLength(root);
    }


    public int findLength(TreeNode node) {

        int l=0;
        if (node.left != null) {
            l = findLength(node.left);
        }

        if (node.right != null) {
            int  temp =  findLength(node.right);

            if (temp > l) {
                l = temp;
            }
        }

        return l+1;

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
