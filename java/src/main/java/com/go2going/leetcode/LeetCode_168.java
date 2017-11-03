package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_168<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/3 0003 12:47
 */
public class LeetCode_168 {



    public String convertToTitle(int n) {

        //余数为0，表示的是A，余数为25表示Z,90,所有线n线减一
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }

    public static void main(String[] args) {
//        System.out.println((int)'A');//65
//        System.out.println((int)'Z');//90
        LeetCode_168 leetCode_168 = new LeetCode_168();
        System.out.println(leetCode_168.convertToTitle(702));


    }
}
