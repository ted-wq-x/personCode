package com.go2going.leetcode;


import java.util.Arrays;

/**
 * 85.33% medium 自己想的
 */
public class LeetCode_698 {
    public static void main(String[] args) {
        LeetCode_698 leetCode_698 = new LeetCode_698();
        System.out.println(leetCode_698.canPartitionKSubsets(new int[]{2, 11, 1, 10, 4, 10, 1, 4, 2

        }, 3));
    }

    /**
     * 对于使用过的数字设置为0
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }

        // 排序，从小到大
        Arrays.sort(nums);

        int val = sum / k;
        //使用数字的时候，优先使用大的，
        for (int i = length - 1; i >= 0 && k > 0; i--) {
            int temp = nums[i];
            nums[i] = 0;
            //每个数字都会进行分组，所以每个数字都有自己的所属，那么如果任何一个数字不满足就说明无法分组
            if (!findSum(val - temp, nums)) {
                return false;
            }
            k--;

        }


        return true;
    }

    private boolean findSum(int target, int[] nums) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        //使用数字的时候，优先使用大的，
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                continue;
            }
            int val = nums[i];
            nums[i] = 0;
            if (findSum(target - val, nums)) {
                return true;
            }
            nums[i] = val;
        }
        return false;
    }
}
