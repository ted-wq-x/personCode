package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_367<br>
 * 描述：>>>为无符号右移
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 19:27
 */
public class LeetCode_367 {

    /**
     * 二分查找，注意long，类型转换
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {

        int min = 1, max = num;

        while (min <= max) {
            long mid = (max + min) >>> 1;
            long i = mid * mid;
            if (i < num) {
                min = (int)mid + 1;
            } else if (i > num) {
                max = (int)mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
