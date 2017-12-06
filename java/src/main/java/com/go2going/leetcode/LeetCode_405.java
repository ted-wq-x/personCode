package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_405<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/5 0005 20:15
 */
public class LeetCode_405 {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);//取4位
            num = num >>> 4;//无符号右移
        }

        return sb.reverse().toString();
    }
}
