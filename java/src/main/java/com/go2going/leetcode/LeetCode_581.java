package com.go2going.leetcode;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_581<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/7 0007 15:12
 */
public class LeetCode_581 {
    /**
     * 也就是除这个子数组外的数是有序的，也就是比较数组内外的最大值和最小值
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);

        int start = 0;
        while (start < n && nums[start] == temp[start]) start++;

        int end = n - 1;
        while (end > start && nums[end] == temp[end]) end--;

        return end - start + 1;
    }

    /**
     * 这个思路不错，也很快
     * @param nums
     * @return
     */
    public int findUnsortedSubarray1(int[] nums) {
        int low = 0, high = nums.length - 1, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        //从两边往中间
        while (low < high && nums[low + 1] >= nums[low]) low++;//原有数组升序low截止位置
        while (high > low && nums[high - 1] <= nums[high]) high--;//原有数组升序high的截止位置

        if (low >= high) return 0;

        //但是会出现中间数组比前面小的情况，或者比后面大的情况
        for (int i = low; i <= high; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        //从中间往两边
        while (low >= 0 && nums[low] > min) low--;
        while (high <= nums.length - 1 && nums[high] < max) high++;

        return high - low - 1;
    }

    public static void main(String[] args) {
        //        int[] s = new int[]{1,2,3,4};
        int[] s = new int[]{2, 6, 4, 8, 10, 9, 15};


        LeetCode_581 leetCode_581 = new LeetCode_581();
        System.out.println(leetCode_581.findUnsortedSubarray(s));
    }
}
