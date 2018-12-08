package com.go2going.leetcode;

public class LeetCode_338 {

    /**
     * 使用jdk方法
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] ans=new int[num+1];
        for (int i = 0; i <= num; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }


    /**
     * 找到的规律
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] ans=new int[num+1];
        for (int i = 0; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
