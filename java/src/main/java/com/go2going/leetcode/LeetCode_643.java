package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_643<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 20:39
 */
public class LeetCode_643 {
    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {

        //第一个窗口的总和
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        //最大总和
        long s = sum;

        for (int i = 1; i <= nums.length-k; i++) {

            //窗口移动，去除第一个窗口，加上新的窗口
            long temp =sum+ nums[k + i-1]-nums[i-1];

            sum = temp;


            s = Math.max(s, temp);

        }

        //转换成double
        return s /1.0/ k;

    }

}
