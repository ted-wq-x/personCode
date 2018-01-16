package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_75<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/16 0016 11:08
 */
public class LeetCode_75 {
    /**
     * 题目的意思是，将0放到左边，2放到右边，中间的都是1
     * @param nums
     */
    public void sortColors(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }

        int low = 0, height = length - 1;


        for (int i = 0; i <= height; ) {
            if (nums[i] == 0) {
                swap(nums, i++, low++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                //==2，i还得继续判断是否符合
                swap(nums, i, height--);
            }
        }

    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
