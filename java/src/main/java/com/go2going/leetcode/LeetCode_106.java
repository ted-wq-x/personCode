package com.go2going.leetcode;

/**
 * @author BlueT
 * 2018/1/21 17:19
 */
public class LeetCode_106 {

    public static void main(String[] args) {
        LeetCode_106 leetCode_10 = new LeetCode_106();
        TreeNode treeNode = leetCode_10.buildTree(new int[]{15, 9, 7, 3, 1, 20, 5}, new int[]{15, 7, 9, 1, 5, 20, 3});
        System.out.println(treeNode);
    }

    int postIndex;

    /**
     * 中序，后序，和105挺相似的，关键是找出规律
     * 在postOrder中，从后往前，每一个元素都是根节点，每个根节点在inOrder中，左右两边分别是左节点和右节点
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = inorder.length - 1;
        return go(0, postIndex, inorder, postorder);

    }


    private TreeNode go(int start, int end, int[] inorder, int[] postorder) {
        if (start > end) {
            return null;
        } else if (start == end) {
            postIndex--;
            return new TreeNode(inorder[start]);
        } else {
            //从后往前遍历性能从23ms--》2ms
            int j = end;
            for (; j >= start; j--) {
                if (inorder[j] == postorder[postIndex]) {
                    postIndex--;
                    break;
                }
            }
            TreeNode node = new TreeNode(inorder[j]);
            //注意：先查找右边，再是左边
            node.right = go(j + 1, end, inorder, postorder);
            node.left = go(start, j - 1, inorder, postorder);
            return node;
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
