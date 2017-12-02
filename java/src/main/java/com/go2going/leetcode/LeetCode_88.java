package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/2 22:09
 */
public class LeetCode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //从后往前取值
        int a1 = m-1, a2 = n-1,k=m+n-1;

        while (a1 > -1 && a2 > -1) {

            nums1[k--] = (nums1[a1] <= nums2[a2]) ? nums2[a2--] : nums1[a1--];

        }

        //a2会剩下，a1剩下的本来就是有序的所以不用管
        while (a2 > -1) {
            nums1[k--] = nums2[a2--];
        }
    }
}
