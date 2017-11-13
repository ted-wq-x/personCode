package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_231<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/13 0013 10:57
 */
public class LeetCode_231 {
    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }

        while (n > 2) {
            if (n % 2 != 0) {
                return false;
            }

            n /= 2;
        }
        return true;
    }

    public boolean isPowerOfTwo1(int n) {
        return ((n & (n-1))==0 && n>0);
    }


    public boolean isPowerOfTwo2(int n) {
        return Integer.bitCount(n) == 1 && n > 0;
    }
}
