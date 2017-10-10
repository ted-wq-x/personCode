package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_538<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/10 0010 18:48
 */
public class LeetCode_538 {


    public TreeNode convertBST(TreeNode root) {
        convert(root);

        return root;
    }

    //保存上一次递归时节点的值
    private int rightSum=0;

    /**
     * 1.理解二叉查找树，知道器特点，找出规律，即val=val+right,left=left+val+right
     * 2.关注点是right,如果right没有直接结束,ps因为我们的思路是求val的值
     * 3.解题方法是：不要关系特殊情况，且只关系val的值，这是根本，因为我们的判断条件是node=null
     * 4. 右-根-左
     * @param node
     */
    public void convert(TreeNode node) {
        if (node == null) {
            return;
        }
        convert(node.right);
        node.val += rightSum;//val的计算方法
        rightSum = node.val;
        convert(node.left);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
