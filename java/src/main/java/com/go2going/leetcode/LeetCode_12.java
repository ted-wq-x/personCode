package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_12<br>
 * 描述：http://blog.csdn.net/beiyeqingteng/article/details/8547565
 *
 * @author wangqiang
 * 创建时间：  2017/12/11 0011 10:56
 */
public class LeetCode_12 {
    public String intToRoman(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                result.append(numerals[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LeetCode_12 leetCode_12 = new LeetCode_12();
        System.out.println(leetCode_12.intToRoman(165));
    }
}
