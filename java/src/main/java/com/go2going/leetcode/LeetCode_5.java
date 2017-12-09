package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/9 19:24
 */
public class LeetCode_5 {

    public static void main(String[] args) {
        LeetCode_5 leetCode_5 = new LeetCode_5();

        System.out.println(leetCode_5.longestPalindrome("babad"));
    }

    /**
     * 最长回文数子字符串,很难，这种思路只能做到这个成绩
     * 133ms
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int len = length;
        while (len >= 1) {
            for (int i = 0; i <= length - len; i++) {
                if (isOk(chars, i, len + i - 1)) {
                    return s.substring(i, i + len);
                }
            }

            len--;
        }
        return "";
    }

    public boolean isOk(char[] s, int start, int end) {
        while (start < end) {
            if (s[start] != s[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }


    /**
     * 从126-》70ms
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int n = s.length();
        int resLen = 0, start = 0, end = 0;
        char[] chars = s.toCharArray();

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = chars[i] == chars[j] && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (j - i + 1 > resLen || resLen == 0)) {
                    start = i;
                    end = j;
                    resLen = j - i;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
