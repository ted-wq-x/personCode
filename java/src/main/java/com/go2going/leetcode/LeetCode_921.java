package com.go2going.leetcode;

public class LeetCode_921 {
    /**
     * 16ms
     * @param S
     * @return
     */
    public int minAddToMakeValid(String S) {
        String s = S.replace("()", "");
        if (!S.equals(s)) {
            return minAddToMakeValid(s);
        }
        return s.length();
    }

    /**
     * 记录（的个数，如果出现）且（的个数大于0那么就可以配对，记录配对的个数
     * @param S
     * @return
     */
    public int minAddToMakeValid2(String S) {
        int l = 0;
        int m = 0;
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (c == '(') ++l;
            if (c == ')' && l > 0) {
                --l;
                ++m;
            }
        }
        return chars.length - m * 2;
    }

    public static void main(String[] args) {
        LeetCode_921 leetCode_921=new LeetCode_921();
        System.out.println(leetCode_921.minAddToMakeValid("())"));
    }
}
