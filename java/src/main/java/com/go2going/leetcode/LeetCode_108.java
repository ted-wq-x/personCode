package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_108<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/16 0016 16:39
 */
public class LeetCode_108 {

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return getNode(nums,0,nums.length-1);
    }


    public TreeNode getNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int i = (start + end) / 2;
        TreeNode node = new TreeNode(nums[i]);
        node.left = getNode(nums, start, i - 1);
        node.right = getNode(nums, i+1, end);
        return node;

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
