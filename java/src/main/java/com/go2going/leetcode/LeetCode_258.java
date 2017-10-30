package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_258<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/30 0030 14:21
 */
public class LeetCode_258 {

    //https://zh.wikipedia.org/wiki/%E6%95%B8%E6%A0%B9
    public int addDigits(int num) {
        return num == 0 ? 0 : num % 9 == 0 ? 9 : num % 9;
    }
}
