package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_583 {
    public static void main(String[] args) {
        LeetCode_583 leetCode_583 = new LeetCode_583();
        // System.out.println(leetCode_583.minDistance("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef",
        System.out.println(leetCode_583.minDistance("intention",
                "execution"
        ));

    }

    /**
     * 64ms
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] cache = new int[length1][length2];
        for (int i = 0; i < length1; i++) {
            Arrays.fill(cache[i], -1);
        }
        int sameCCount = count(word1, word2, 0, 0, cache);
        return length1 + length2 - 2 * sameCCount;

    }

    private int count(String word1, String word2, int s1, int s2, int[][] cache) {
        int length = word1.length();
        int length2 = word2.length();
        if (s1 >= length || s2 >= length2) {
            return 0;
        }
        if (cache[s1][s2] != -1) {
            return cache[s1][s2];
        }
        int sameCCount = 0;
        for (int i = s1; i < length; i++) {
            if (i + sameCCount >= length) break;
            for (int j = s2; j < length2; j++) {
                if (j + sameCCount >= length2) break;
                if (word1.charAt(i) == word2.charAt(j)) {
                    sameCCount = Math.max(sameCCount, 1 + count(word1, word2, i + 1, j + 1, cache));
                }
            }
        }
        cache[s1][s2] = sameCCount;
        return sameCCount;
    }


    /**
     * dp解 19ms
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance2(String word1, String word2) {
        char[] cs1 = word1.toCharArray(), cs2 = word2.toCharArray();
        int[] dp = new int[cs2.length + 1];
        for (int i = 1; i <= cs2.length; ++i) dp[i] = i;
        for (int i = 1; i <= cs1.length; ++i) {
            int prev = dp[0];
            dp[0] = i;
            for (int j = 1; j <= cs2.length; ++j) {
                int temp = prev;
                prev = dp[j];
                if (cs1[i - 1] != cs2[j - 1]) temp = Math.min(dp[j], dp[j - 1]) + 1;
                dp[j] = temp;
            }
        }
        return dp[cs2.length];
    }

    /**
     * 这个dp很好理解，对于w1,w2中的i,j位置，有3中情况，i和为w2中的相等,j和w1中的相等，i和j都没有相等的
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance3(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;

        // dp[i][j] stands for distance of first i chars of word1 and first j chars of word2
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
            dp[i][0] = i;
        for (int j = 0; j <= len2; j++)
            dp[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 2, dp[i - 1][j] + 1), dp[i][j - 1] + 1);
            }
        }

        return dp[len1][len2];
    }
}
