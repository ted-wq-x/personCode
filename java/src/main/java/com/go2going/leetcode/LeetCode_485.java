package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_485<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/31 0031 17:08
 */
public class LeetCode_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int temp=0;
        for (int num : nums) {
            if (num == 1) {
                temp++;
            } else {
                sum = Math.max(sum, temp);
                temp = 0;
            }
        }

        if (temp != 0) {
            sum = Math.max(sum, temp);
        }

        return sum;
    }
}
