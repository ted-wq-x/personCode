package com.go2going.leetcode;

public class LeetCode_260 {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int temp = 0;
        for (int num : nums) {
            temp^=num;
        }
        //temp存储两个数xor的结果，下面的问题是如何分离出这两个数
        //下面的处理方式是真的想不出，但是可以换一种思路

        /*// Get its last set bit
        temp &= -temp;

        // Pass 2 :
        for (int num : nums)
        {
            if ((num & temp) == 0) // the bit is not set
            {
                ans[0] ^= num;
            }
            else // the bit is set
            {
                ans[1] ^= num;
            }
        }*/
        //从右边开始查找第一个不相等的位，即那一位为1，
        int mask = 1;
        while ((mask & temp)==0 ) {
            mask <<= 1;
        }
        for (int num : nums) {
            //这样就找到了区分两个数的方式,这很容易理解，因为对于重复的数，肯定分在一组当中，所以xor的结果为原值，所以剩下的就是单独的值
            if (((num & mask) == 0)) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
