package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_43<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/27 0027 18:23
 */
public class LeetCode_43 {

    /**
     * 计算的是乘积fuck，我以为是加,大神级的思路，牛逼，完全模仿手算乘法的方式，使用数组进行累积
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int m = chars1.length, n = chars2.length;
        //数组大小M+N也很有意思
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (chars1[i] - '0') * (chars2[j] - '0');
                int p1 = i + j, p2 = i + j + 1;
                //当前值+进位
                int sum = mul + pos[p2];

                //p1为进位
                pos[p1] += sum / 10;
                //p2为值
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }


    public static void main(String[] args) {
        LeetCode_43 leetCode_43 = new LeetCode_43();
        System.out.println(leetCode_43.multiply("123", "456"));
    }
}
