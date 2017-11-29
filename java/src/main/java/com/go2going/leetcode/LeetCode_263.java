package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_263<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 18:50
 */
public class LeetCode_263 {
    public boolean isUgly(int num) {

        if (num <= 0) {
            return false;
        }

        if (num == 1) {
            return true;
        }

        while (num % 2 == 0) {
            num = num / 2;
        }
        while (num % 3 == 0) {
            num = num / 3;
        }
        while (num % 5 == 0) {
            num = num / 5;
        }

        return num == 1;
    }
}
