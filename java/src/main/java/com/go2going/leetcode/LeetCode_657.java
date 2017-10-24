package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_657<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/24 0024 13:58
 */
public class LeetCode_657 {
    public boolean judgeCircle(String moves) {
        int[] sum = new int[26];
        char[] chars = moves.toCharArray();
        for (char a : chars) {
            sum[a - 65]++;
        }

        return sum[3] ==sum[20]&& sum[11] == sum[17];
    }

    public static void main(String[] args) {
        System.out.println((int)'U');//85-65=20
        System.out.println((int)'D');//68-65=3
        System.out.println((int)'L');//76-65=11
        System.out.println((int)'R');//82-65=17
    }
}
