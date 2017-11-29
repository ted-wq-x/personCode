package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_342<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 19:09
 */
public class LeetCode_342 {
    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }

        while (num % 4 == 0) {
            num = num / 4;
        }
        return num == 1;
    }


    public boolean isPowerOfFou1(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }


    public static void main(String[] args) {
        int num = 16;
        while (num % 4 == 0) {
            num = num / 4;
        }
        System.out.println(num==1);
    }
}
