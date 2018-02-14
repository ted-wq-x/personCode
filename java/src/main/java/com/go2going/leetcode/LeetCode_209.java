package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_209<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/14 0014 16:22
 */
public class LeetCode_209 {


    /**
     * 滑动窗口(满足连续的条件)，窗口的大小就是s，即宽度大于等于s
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int sum = 0, min = Integer.MAX_VALUE;
        //窗口的左边界
        int l = 0;
        // i是窗口的右边界
        for (int i = 0; i < length; i++) {
            sum += nums[i];

            //满足窗口宽度，因为求的是宽度的最小值，所以也不需要考虑其他的情况
            while (sum >= s) {
                //从0开始，所以+1
                min = Math.min(min, i - l + 1);
                sum -= nums[l++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
