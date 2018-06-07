package com.go2going.leetcode;

/***
 * medium
 */
public class LeetCode_238 {

    /**
     * great
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        //从左往右X，获取每个数左边的乘积
        for (int i = 1; i < n; i++) {
            //将计算的是直接放到数据中，当前数的左边累积=前一个数的累积*前一个数
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        //从右往左X，乘上每个数右边的乘积
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            //不断的累加乘积
            right *= nums[i];
        }
        return res;
    }
}
