package com.go2going.leetcode;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_561<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/24 0024 13:24
 */
public class LeetCode_561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i=i+2) {
            sum += nums[i];
        }
        return sum;
    }
}
