package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BlueT
 * 给出两个数组A和B，其中A是B的子集，同时保证每个数组内元素唯一。求对于A数组内每一个元素，对应在B数组中下一个比它大的元素是多少。若找不到，输出-1。
 * 注意是在B数组中的位置，之后的下一个比这个数大的位置
 * 2017/10/28 19:20
 */
public class LeetCode_496 {

    /**
     * 最简单的方式,缺点是之前查找的元素还需要重复查找
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int length1 = nums2.length;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            int i1 = nums1[i];
            int index=0;
            for (int j=0;j<length1;j++) {
                if (nums2[j] == i1) {
                    index=j;
                    break;
                }
            }
            for (int j = index; j < length1; j++) {
                if ( nums2[j] > i1) {
                    nums[i] = nums2[j];
                    break;
                }
            }

            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        return nums;
    }

    /**
     * 7ms
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int length = nums2.length;
        int length1 = nums1.length;
        int[] nums = new int[length1];

        //一次性找到位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < length1; i++) {
            int i1 = nums1[i];
            for (int j = map.get(i1); j < length; j++) {
                if ( nums2[j] > i1) {
                    nums[i] = nums2[j];
                    break;
                }
            }

            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        return nums;
    }
}
