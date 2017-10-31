package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_693<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/31 0031 16:01
 */
public class LeetCode_693 {
    public boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) return false;
        }
        return true;
    }

    public boolean hasAlternatingBits1(int n) {
        //TODO 没明白
        n ^= n/4; //右移2位,xor:100
        int k =n -1;//         011
        return (n&k)==0;  //    000
    }

    public static void main(String[] args) {
        LeetCode_693 leetCode_693 = new LeetCode_693();
        System.out.println(leetCode_693.hasAlternatingBits1(4));
    }
}
