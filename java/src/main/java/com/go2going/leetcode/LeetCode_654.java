package com.go2going.leetcode;

public class LeetCode_654 {


    /**
     * 7ms
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return make(nums, 0,nums.length);
    }

    /**
     *
     * @param nums
     * @param start include
     * @param end exclude
     * @return
     */

    private TreeNode make(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int maxIndex = 0, maxValue = Integer.MIN_VALUE;


        for (int i = start; i < end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }


        TreeNode node = new TreeNode(maxValue);
        node.left = make(nums, start, maxIndex);
        node.right = make(nums, maxIndex + 1, end);
        return node;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
