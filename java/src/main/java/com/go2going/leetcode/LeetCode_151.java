package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_151<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/14 0014 13:03
 */
public class LeetCode_151 {
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();


        for (int i = parts.length-1; i >0 ; --i) {
            sb.append(parts[i]);
            sb.append(" ");
        }

        return sb.append(parts[0]).toString();
    }

    public static void main(String[] args) {
        LeetCode_151 leetCode_151 = new LeetCode_151();
        System.out.println(leetCode_151.reverseWords("   a   b "));
    }
}
