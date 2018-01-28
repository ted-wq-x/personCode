package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_152<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/25 0025 16:47
 */
public class LeetCode_152 {


    /**
     * 相邻元素的最大乘积
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;    // global max
        int maxloc = 1, minloc = 1;     // max or min end here
        for (int num : nums) {          // negative could cause maxloc and minloc swap
            int prod1 = maxloc * num, prod2 = minloc * num;
            maxloc = Math.max(num, Math.max(prod1, prod2));
            minloc = Math.min(num, Math.min(prod1, prod2));
            max = Math.max(max, maxloc);
        }
        return max;
    }




}
