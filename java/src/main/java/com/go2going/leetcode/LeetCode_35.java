package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_35<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/8 0008 19:24
 */
public class LeetCode_35 {
    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int end = length - 1;
        int start = 0;

        // bs算法
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;

            } else {
                return mid;
            }
        }

        return start;//此处的值正好是满足题意的
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1}, 0));
    }
}
