package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_680<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/8 0008 15:16
 */
public class LeetCode_680 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0, j = length - 1; i < j; ) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
                continue;
            }
            //不相等
            return isOk(chars, i + 1, j)||isOk(chars, i , j-1);

        }

        return true;
    }

    public boolean isOk(char[] chars, int l, int r) {
        //如abca
        if (l >= r) {
            return true;
        }
        for (int i = l,j=r; i < r; i++,j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }

        return true;
    }
}
