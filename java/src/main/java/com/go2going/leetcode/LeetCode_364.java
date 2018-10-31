package com.go2going.leetcode;

public class LeetCode_364 {

    /**
     * 找规律的题目
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {

        int[] nums = new int[n + 1];
        nums[1] = 1;
        int a = 0, b = 0, c = 0;
        int av = nums[1];
        int bv = nums[1];
        int cv = nums[1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Math.min(av, Math.min(bv, cv));
            if (nums[i] == av) {
                av = nums[++a] * 2;
            }

            if (nums[i] == bv) {
                bv = nums[++b] * 3;
            }

            if (nums[i] == cv) {
                cv = nums[++c] * 5;
            }
        }

        return nums[n];
    }

    public static void main(String[] args) {
        LeetCode_364 leetCode_364=new LeetCode_364();
        System.out.println(leetCode_364.nthUglyNumber(12));
    }

}
