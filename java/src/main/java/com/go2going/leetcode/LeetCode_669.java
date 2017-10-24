package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_669<br>
 * 描述：二叉搜索树的性质，左节点的值小于等于root，右节点的值大于root
 * 参考：https://www.youtube.com/watch?v=L_t2x3nH61k
 *
 * @author wangqiang
 * 创建时间：  2017/10/24 0024 15:32
 */
public class LeetCode_669 {

    /**
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {

        if(root==null) return null;

        //1. 小于最小值，则舍弃左子树
        if(root.val<L){
          return  trimBST(root.right, L, R);
        }

        //2. 大于最大值，则舍弃右子树
        if(root.val>R){
            return  trimBST(root.left, L, R);
        }

        //3. val在L和R之间
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
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

