package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_453<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/3 0003 16:50
 */
public class LeetCode_453 {
    /**
     * 数学问题
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {

        //原先舒张压的总和sum,长度length,异动次数n,min为最小值
        //sum+n*(length-1)=min+n

        int min = Integer.MAX_VALUE, sum = 0,length=nums.length;
        for (int i = 0; i <length ; i++) {
            int num = nums[i];

            sum += num;
            if (num < min) {
                min = num;
            }
        }


        return sum - min * length;
    }
}
