package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_674<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/16 0016 16:31
 */
public class LeetCode_674 {

    public int findLengthOfLCIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int pre = nums[0];
        int maxLength = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                maxLength++;
                pre = nums[i];
            } else {
                pre = nums[i];
                max = Math.max(max, maxLength);
                maxLength = 1;
            }
        }

        max = Math.max(max, maxLength);

        return max;
    }
}
