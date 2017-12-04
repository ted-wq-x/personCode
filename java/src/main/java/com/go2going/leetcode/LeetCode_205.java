package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_205<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/4 0004 10:28
 */
public class LeetCode_205 {

    /**
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isIsomorphic(String s1, String s2) {

        int[] m = new int[512];

        //记录每个字母的使用位置，相同的就替代，但是如果这个字母被别的位置使用了，值就不相同了
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((char)257);
    }
}
