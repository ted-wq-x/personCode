package com.go2going.leetcode;

public class LeetCode_942 {
    /**
     * easy
     * @param S
     * @return
     */
    public int[] diStringMatch(String S) {

        int length = S.length();
        char[] chars = S.toCharArray();
        int min = 0, max = length;

        int[] ans = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (chars[i] == 'I') {
                ans[i] = min++;
            } else {
                ans[i] = max--;
            }
        }
        if (chars[length - 1] == 'I') {
            ans[length]=min;
        }else {
            ans[length]=max;
        }

        return ans;
    }
}
