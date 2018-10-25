package com.go2going.leetcode;

public class LeetCode_456 {
    public static void main(String[] args) {
        LeetCode_456 leetCode_456 = new LeetCode_456();
        System.out.println(leetCode_456.find132pattern(new int[]{3, 1, 4, 2}));
    }

    /**
     * 326ms 很差劲,但是好于O(n^2)
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int[] minA = new int[length];
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] < min) {
                min = nums[i - 1];
            }
            minA[i] = min;
        }


        for (int i = 1; i < length - 1; i++) {
            if (nums[i] > minA[i]) {
                //问题在于找右边的小于当前的最大值
                for (int y = i + 1; y < length; y++) {
                    if (nums[y] < nums[i] && nums[y] > minA[i]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }




    /**
     * 8ms，但是看不懂
     * @param nums
     * @return
     */
    public boolean find132pattern2(int[] nums) {
        int n = nums.length, top = n, third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) return true;
            while (top < n && nums[i] > nums[top])
                third = nums[top++];
            nums[--top] = nums[i];
        }

        return false;
    }
}
