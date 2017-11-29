package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_66<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 11:22
 */
public class LeetCode_66 {

    /**
     * discuss的这个思路非常的号
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int length = digits.length;

        //仔细思考，这个是没有我问题的
        for (int i = length-1; i >=0 ; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        //到这，说明，数组不够了，也就是+1的最大情况
        int[] i = new int[length + 1];
        i[0] = 1;
        return i;

    }
}
