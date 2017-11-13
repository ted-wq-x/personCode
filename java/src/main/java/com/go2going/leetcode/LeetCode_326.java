package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_326<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/13 0013 11:04
 */
public class LeetCode_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0||n ==2) {
            return false;
        }

        while (n >1) {
            if (n % 3!= 0) {
                return false;
            }

            n /= 3;
        }
        return true;
    }

    public boolean isPowerOfThree1(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }

    public static void main(String[] args) {
        LeetCode_326 leetCode_326 = new LeetCode_326();
        System.out.println(leetCode_326.isPowerOfThree(6));
    }
}
