package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_283<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/23 0023 12:54
 */
public class LeetCode_283 {

    /**
     * 将不为0的数前移，index后面的布0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int length = nums.length;

        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < length; i++) {
            nums[index++] = 0;
        }
    }
}
