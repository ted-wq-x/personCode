package com.go2going.leetcode;

import java.util.Arrays;

/**
 * @author BlueT
 * 2017/11/5 11:29
 */
public class LeetCode_506 {
    /**
     * 24.9%
     * @param nums
     * @return
     */
    public String[] findRelativeRanks(int[] nums) {

        int length = nums.length;

        //二维数组，0放位置，1放数字
        int[][] index = new int[length][2];
        for (int i = 0; i < length; i++) {
            index[i][0] = i;
            index[i][1] = nums[i];
        }

        //对数字进行排序，从大到小
        Arrays.sort(index, (a, b) ->b[1]-a[1] );

        String[] str = new String[length];


        //遍历二位数字的0，获取位置，进行赋值
        for (int i = 0; i < length; i++) {
            int i1 = index[i][0];
            if (i == 0) {
                str[i1] = "Gold Medal";
            } else if (i == 1) {
                str[index[i][0]] = "Silver Medal";
            } else if (i == 2) {
                str[i1] = "Bronze Medal";
            }else {
                str[i1] = String.valueOf(i + 1);
            }
        }

        return str;
    }
}
