package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_307 {

    public static void main(String[] args) {
        NumArray numArray = new LeetCode_307().new NumArray(new int[]{9, -8});
        numArray.update(0, 3);
        System.out.println(numArray.sumRange(1, 1));
        System.out.println(numArray.sumRange(0, 1));
        numArray.update(1, -3);
        System.out.println(numArray.sumRange(0, 1));
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * obj.update(i,val);
     * int param_2 = obj.sumRange(i,j);
     */
    /*
    //最笨的方式
    class NumArray {
        private int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public void update(int i, int val) {
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            int ans = 0;
            for (int x = i; x <= j; x++) {
                ans += nums[x];
            }
            return ans;
        }

    }
    */
    class NumArray {
        private int[] nums;
        private int[] sum;

        public NumArray(int[] nums) {
            this.nums = nums;
            int length = nums.length;
            this.sum = new int[length];
            if (length == 0) {
                return;
            }
            sum[0] = nums[0];
            for (int i = 1; i < length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }

        public void update(int i, int val) {
            int diff = nums[i] - val;
            nums[i] = val;
            for (int x = i; x < nums.length; x++) {
                sum[x] -= diff;
            }
        }

        public int sumRange(int i, int j) {
            if (i == j) {
                return nums[i];
            }
            if (i == 0) {
                return sum[j];
            }
            return (sum[j] - sum[i - 1]);
        }

    }

}
