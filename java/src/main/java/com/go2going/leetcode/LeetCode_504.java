package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_504<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/13 0013 10:35
 */
public class LeetCode_504 {
    public String convertToBase7(int num) {

        StringBuilder sb = new StringBuilder();
        boolean is = false;
        if (num < 0) {
            is = true;
            num = -num;
        }
        while (num >= 7) {
            sb.append(num % 7);
            num /= 7;
        }
        sb.append(num);
        if (is) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode_504 leetCode_504 = new LeetCode_504();
        System.out.println(leetCode_504.convertToBase7(100));
    }
}
