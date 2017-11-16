package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_268<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/16 0016 17:05
 */
public class LeetCode_268 {

    /**
     *  a^b^b =a
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {

        //length这个值取值不到，得补上
        int length = nums.length;
        //xor初始值只能为0
        int xor = 0;
        for (int i = 0; i <length ; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ length;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0}));
    }
}
