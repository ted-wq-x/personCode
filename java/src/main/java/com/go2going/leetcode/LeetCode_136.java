package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_136<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/30 0030 14:04
 */
public class LeetCode_136 {
    public int singleNumber(int[] nums) {

        int sum = 0;

        for (int num : nums) {
            sum ^= num;
        }

        return sum;
    }


    public static void main(String[] args) {
        LeetCode_136 leetCode_136 = new LeetCode_136();
        System.out.println(leetCode_136.singleNumber(new int[]{10, 2, 2, 3, 54, 3, 54}));
    }
}
