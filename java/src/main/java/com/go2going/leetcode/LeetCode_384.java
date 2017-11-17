package com.go2going.leetcode;

import java.util.Random;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_384<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/17 0017 9:53
 */
public class LeetCode_384 {
    class Solution{
        private int[] nums;
        private Random random=new Random();
        public Solution(int[] nums) {
            this.nums=nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            if(nums==null) return null;
            int[] a=nums.clone();
            for(int i=0;i<a.length;i++){
                //不包含
                int index = random.nextInt(i+1);
                swap(a,i,index);
            }

            return a;
        }


        private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
