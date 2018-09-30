package com.go2going.leetcode;

public class LeetCode_337 {

    /**
     * 自己想的，虽然可以但是效果太差，问题关键是相同的点计算2次
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        return go(root, true);

    }


    private int go(TreeNode root, boolean ok) {
        if (root == null) {
            return 0;
        }

        int max =go(root.left, true)+go(root.right, true);


        if (ok) {
            max = Math.max(max, root.val + go(root.left, false) + go(root.right, false));
        }

        return max;
    }


    /**
     * 改进，性能很好
     * @param root
     * @return
     */
    public int rob2(TreeNode root) {
        int[] ints = go2(root);
        return Math.max(ints[0],ints[1]);

    }


    /**
     * 0 是不加root.val,1是加
     * @param root
     * @return
     */
    private int[] go2(TreeNode root) {
        if (root == null) {
            return new int[]{0,0};
        }

        int[] left = go2(root.left);
        int[] right = go2(root.right);
        int[] res = new int[2];

        // 不加当前点的值，去左右两边最大的值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
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
