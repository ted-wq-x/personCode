package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/2 20:10
 */
public class LeetCode_28 {

    /**
     * 有点绕人
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {//haystack
            for (int j = 0; ; j++) {//needle
                //j能到needle的长度也就是前面的0到length-1都是相等的
                if(j==needle.length()){
                    return i;
                }

                //防止下面的+j就越界了
                if (i + j == haystack.length()) {
                    return -1;
                }

                //只要有一个不相等，那么就推出needle的循环
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }

            }
        }
    }

}
