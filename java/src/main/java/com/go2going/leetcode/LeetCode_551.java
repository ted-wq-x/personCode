package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_551<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/16 0016 16:59
 */
public class LeetCode_551 {

    public boolean checkRecord(String s) {

        char[] chars = s.toCharArray();

        int A = 0;
        int L = 0;

        for (char c : chars) {
            if (c == 'A') {
                A++;
                if (A >= 2) {
                    return false;
                }
                L = 0;
            } else if (c == 'L') {
                L++;
                if (L >= 3) {
                    return false;
                }
            } else {
                L = 0;
            }
        }
        return true;
    }
}
