package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_55<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/2 0002 12:47
 */
public class LeetCode_55 {

    /**
     * 贪婪算法
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        //保存最远的距离
        int reach = nums[0];
        int length = nums.length;
        //多的判断条件是在有效范围内
        for (int i = 1; i < length && i <= reach; i++) {

            if (reach < i + nums[i]) {
                reach = i + nums[i];
            }
        }
        return reach >= length - 1;
    }
}
