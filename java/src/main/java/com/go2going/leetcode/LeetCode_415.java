package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_415<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/15 0015 20:11
 */
public class LeetCode_415 {
    public static String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int temp = 0;


        //1>2
        int i1 = num1.length();
        int i2 = num2.length();

        boolean isAdd = false;
        if (i1 < i2) {
            String ss = num2;
            num2 = num1;
            num1 = ss;

            i1 ^= i2;
            i2 ^= i1;
            i1 ^= i2;
        }


        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();

        for (int i = 0; i < i2; i++) {
            int i3 = char1[i1-i-1] - '0' + char2[i2-i-1] - '0' + temp;
            if (i3 >= 10) {
                String s = i3 + "";
                sb.append(s.charAt(1));
                temp = s.charAt(0) - '0';
                isAdd = true;
            } else {
                sb.append(i3);
                isAdd = false;
                temp = 0;
            }
        }


        for (int i = i2; i < i1; i++) {
            int i3 = char1[i1-i-1] - '0' + temp;
            if (i3 >= 10) {
                String s = i3 + "";
                sb.append(s.charAt(1));
                temp = s.charAt(0) - '0';
                isAdd = true;
            } else {
                sb.append(i3);
                isAdd = false;
                temp = 0;
            }
        }

        if (isAdd) {
            sb.append(temp);
        }

        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addStrings("408", "5"));
    }

}
