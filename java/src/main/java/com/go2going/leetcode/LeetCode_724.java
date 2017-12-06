package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_724<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/5 0005 18:55
 */
public class LeetCode_724 {
    public int pivotIndex(int[] nums) {

        int length = nums.length;

        if (length == 0) {
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }

        int leftsum = 0;//左边的累积和
        for (int i = 0; i < length; i++) {
            //如果左边*2+index==sum那么i就是相等处
            if (sum == leftsum + leftsum + nums[i]) {
                return i;
            }
            leftsum = leftsum + nums[i];
        }
        return -1;

    }

    public static void main(String[] args) {
        LeetCode_724 leetCode_724 = new LeetCode_724();
        System.out.println(leetCode_724.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
