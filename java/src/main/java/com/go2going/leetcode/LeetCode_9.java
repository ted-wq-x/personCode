package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_9<br>
 * 描述：回文数：将这个数的数字按相反的顺序重新排列后，所得到的数和原来的数一样。负数不是回文数
 *
 * @author wangqiang
 * 创建时间：  2017/12/1 0001 10:10
 */
public class LeetCode_9 {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);

        for (int i = 0, j = s.length()-1;i<=j;) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }


        }
        return true;
    }
}
