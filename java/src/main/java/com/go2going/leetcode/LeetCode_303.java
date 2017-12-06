package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_303<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/5 0005 19:47
 */
public class LeetCode_303 {
    class NumArray {

        int[] sum;
        public NumArray(int[] nums) {
            int length = nums.length;
            sum = new int[length];
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    sum[0] = nums[0];
                } else {
                    sum[i] = sum[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) {
                return sum[j];
            }
            return sum[j] - sum[i-1];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
}
