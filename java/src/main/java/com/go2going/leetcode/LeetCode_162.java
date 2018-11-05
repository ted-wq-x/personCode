package com.go2going.leetcode;

public class LeetCode_162 {
    /**
     * 二分查找
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (end - start >= 2) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return nums[start]>nums[end]?start:end;
    }


}
