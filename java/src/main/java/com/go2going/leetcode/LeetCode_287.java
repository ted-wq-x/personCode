package com.go2going.leetcode;

public class LeetCode_287 {
    /**
     * 我理解错了，以为只有一个数重复，且只重复一次，其实可以重复很多次
     *
     * @param nums
     * @return
     */
    public int findDuplicate_error(int[] nums) {
        int length = nums.length;
        int ans = nums[0];
        for (int i = 1; i < length ; i++) {
            ans ^= i;
            ans ^= nums[i];
        }

        return ans;
    }

    /**
     * 使用二分查找，统计小于mid的个数count，如果count<=mid,那重复的数必然大于mid
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int start = 1, end = length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            int count = 0;
            for (int i = 0; i < length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            //+1很好理解，因为在1到mid之间都不可能，所以下面的循环从+1开始就好
            if (count <= mid) {
                start = mid+1;
            } else {
                //不能=1,因为从1到mid都有可能，如果-1的话，就将mid去掉了
                end = mid;
            }
        }


        return start;
    }
    public static void main(String[] args) {
        LeetCode_287 leetCode_287=new LeetCode_287();
        System.out.println(leetCode_287.findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(leetCode_287.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
