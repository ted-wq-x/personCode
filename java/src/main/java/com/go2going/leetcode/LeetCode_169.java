package com.go2going.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author BlueT
 * 2017/11/4 20:43
 */
public class LeetCode_169 {
    /**
     * 题目意思转变成求出现次数最多的数字，但是这样做的效率低
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int le = nums.length;
        int cur = 0, n = 0;

        int c = nums.length / 2+1;
        //key=数字,value=次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < le; j++) {
            int num = nums[j];
            Integer integer = map.get(num);
            int temp=1;
            if (integer != null) {
                temp=integer+1;
            }
            if (temp>=c&&temp > n) {
                n = temp;
                cur = num;
            }
            map.put(num, temp);
        }

        return cur;
    }

    /**
     * 将数组排序，则中间的那个元素一定是多数元素
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 相同的家1，不同的减一，数学原理不清楚
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int index = nums[0], count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                index = nums[i];
                count++;
            } else if (nums[i] == index) {
                count++;
            } else {
                count--;
            }
        }

        return index;
    }
}
