package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_171<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/3 0003 12:46
 */
public class LeetCode_171 {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();

        int length = chars.length;


        int sum = 0;
        for (int i = 0; i < length; i++) {
            int aChar = chars[i]-64;
            sum += aChar * Math.pow(26, length-i-1);
        }
        return sum;
    }


}
