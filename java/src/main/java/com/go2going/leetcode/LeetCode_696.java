package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_696<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/1 0001 9:45
 */
public class LeetCode_696 {
    /**
     * 没写出来
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int cur = 1,pre=0,sum = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                cur++;
            } else {
                pre = cur;
                cur=1;//复位
            }

            //亮点
            if (pre >=cur) {
                sum++;
            }
        }
        return sum;
    }
}
