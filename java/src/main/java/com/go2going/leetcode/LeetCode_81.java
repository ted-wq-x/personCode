package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_81 {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return nums[0]==target;
        }
        int pre = 0;
        for (int i = 1; i < length; i++) {
            if (nums[pre] == target) {
                return true;
            }
            if (nums[pre] > nums[i]) {
                //只能对从小到大排序的进行查找
                return Arrays.binarySearch(nums,pre+1, length, target) >= 0;
            }

            pre = i;
        }
        if (nums[length - 1] == target) {
            return true;
        }
        return binarySearch0(nums,0,length,target) >= 0;

    }
    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal > key)
                low = mid + 1;
            else if (midVal < key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    public static void main(String[] args) {
        LeetCode_81 leetCode_81=new LeetCode_81();
        System.out.println(leetCode_81.search(new int[]{1,2,1}, 2));
    }
}
