package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/3 15:40
 */
public class LeetCode_112 {
    /**
     * 在下面的方法上进行了精简
     * @param node
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }

        sum = sum - node.val;

        //判断是叶子节点
        if (sum == 0 && node.left == null && node.right == null) {
            //有可能不是叶子节点，sum就==0，所以还得递归
            return true;
        }

        return hasPathSum(node.right, sum)|| hasPathSum(node.left, sum);
    }


    public boolean hasPathSum1(TreeNode root, int sum) {
        return root != null && isOk(root, sum);
    }

    public boolean isOk(TreeNode node, int sum) {
        if (node == null) {
            return sum == 0;
        }

        sum = sum - node.val;
        if (sum == 0) {
            //判断是叶子节点
            if(node.left == null && node.right == null){
                return true;
            }
        }
        boolean b = false;
        if (node.left != null) {
            b = isOk(node.left, sum);
        }
        boolean c = false;
        if (node.right != null) {
            c= isOk(node.right, sum);
        }

        return  c||b ;

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
