package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_26<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/1 0001 10:24
 */
public class LeetCode_26 {
    public int removeDuplicates(int[] nums) {

        if (nums == null||nums.length==0) {
            return 0;
        }
        int length1 = nums.length;
        int preNUm = nums[0];
        int length = 1;
        for (int i = 1; i < length1;   i++) {
            if (nums[i] != preNUm) {
                nums[length++] = nums[i];
                preNUm = nums[i];
            }
        }

        return length;
    }

    public static void main(String[] args) {
        LeetCode_26 leetCode_26 = new LeetCode_26();
        leetCode_26.removeDuplicates(new int[]{1, 1, 2});
    }
}
