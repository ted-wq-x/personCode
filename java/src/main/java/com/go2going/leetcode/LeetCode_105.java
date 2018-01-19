package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_105<br>
 * 描述：TODO
 *
 * @author wangqiang
 * 创建时间：  2018/1/19 0019 16:52
 */
public class LeetCode_105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    //记录pre的位置
    int length = 0;

    /**
     * https://www.tianmaying.com/tutorial/LC105
     * 对于给定的前序遍历preorder和中序遍历inorder，首先我们不难发现，这棵树的根结点其实就是preorder[0]。由于preorder和inorder是对同一棵树的遍历，我们可以知道preorder[0]在inorder中一定也存在，不妨设preorder[0]==inorder[k]。

     由于inorder是中序遍历，所以k左边的就是根节点左子树的中序遍历、k右边的就是根节点右子树的中序遍历。

     并且，由于我们已经知道了根节点左子树的节点数（与中序遍历长度相同），不妨设为l，我们可以知道preorder从1到l+1就是根节点左子树的前序遍历，剩下的最后一部分就是根节点右子树的前序遍历。

     也就是说，我们可以计算出左子树、右子树的前序遍历和中序遍历，从而可以用分治的思想，将规模较大的问题分解成为两个较小的问题，然后递归的进行处理，还原左子树和右子树，最后连通根节点一起组成一棵完整的树。
     *
     * 给定树的前序和中序，构造二叉树。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        return go(preorder, inorder, 0, length-1);
    }


    /**
     * []
     [1,2,3,4]
     * @param pre
     * @param in
     * @param preS
     * @param preE
     * @return
     */
    private TreeNode go(int[] pre, int[] in,int preS,int preE) {
        if (preS > preE) {
            return null;
        } else if (preS == preE) {
            return new TreeNode(pre[length++]);
        }

        int x = pre[length++];
        TreeNode node = new TreeNode(x);
        int i = preS;
        for (; i <= preE; i++) {
            if (in[i] == x) {
                break;
            }
        }

        node.left = go(pre, in, preS, i-1);
        node.right = go(pre, in, i+1, preE);

        return node;
    }

    public static void main(String[] args) {
        LeetCode_105 leetCode_105 = new LeetCode_105();

        TreeNode node = leetCode_105.buildTree(new int[]{3,2,1,4}, new int[]{1,2,3,4});


        System.out.println(node);
    }
}
