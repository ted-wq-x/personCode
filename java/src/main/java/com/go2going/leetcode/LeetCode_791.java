package com.go2going.leetcode;

public class LeetCode_791 {

    /**
     * 小写字母a-z：97-122
     * 100% 哈哈，自己想的
     *
     * @param S
     * @param T
     * @return
     */
    public String customSortString(String S, String T) {
        //每个字母的顺序，小的在前面，从小到大
        int[] sort = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sort[i] =chars[i]-97  ;
        }

        //保存每个字母出现的次数
        int[] ts=new int[26];
        char[] tc = T.toCharArray();
        for (char c : tc) {
            int i = c - 97;
            ts[i]=ts[i]+1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = (char) (sort[i] + 97);
            for (int j = 0; j < ts[sort[i]]; j++) {
                sb.append(c);
            }
            ts[sort[i]] = 0;
        }


        //在S中不存在的，取出来
        for (int i = 0; i < ts.length; i++) {
            if (ts[i] != 0) {
                for (int j = 0; j < ts[i]; j++) {
                    char val = (char)(i + 97);
                    sb.append(val);
                }
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        LeetCode_791 leetCode_791=new LeetCode_791();
        System.out.println(leetCode_791.customSortString("cba", "abcd"));
    }


}
