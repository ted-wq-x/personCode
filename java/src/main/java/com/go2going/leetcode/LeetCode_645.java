package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_645<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/27 0027 9:33
 */
public class LeetCode_645 {
    public int[] findErrorNums(int[] nums) {

        int[] ints = new int[2];
        int[] s = new int[nums.length+1];
        int t = 0;//t最后剩下的就是重复的^缺少的
        for (int i = 0; i <nums.length; i++) {
            t ^= i+1 ;
            t ^= nums[i];
            if (++s[nums[i]] == 2) {
                //找到重复的
                ints[0] = nums[i];
            }
        }
        ints[1] = t^ints[0];
        return ints;
    }
}
