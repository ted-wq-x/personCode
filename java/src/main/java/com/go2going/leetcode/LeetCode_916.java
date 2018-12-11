package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_916 {
    public static void main(String[] args) {
        LeetCode_916 leetCode_916 = new LeetCode_916();
        List<String> strings = leetCode_916.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                new String[]{"ec", "oc", "ceo"});
        strings.forEach(System.out::println);
    }

    /**
     * 56ms
     * @param A
     * @param B
     * @return
     */
    public List<String> wordSubsets(String[] A, String[] B) {
        int length = A.length;
        int[][] cache = new int[length][26];
        for (int i = 0; i < A.length; i++) {
            int[] ints = cache[i];
            char[] chars = A[i].toCharArray();
            for (char c : chars) {
                ints[c - 'a']++;
            }
        }
        List<String> ans = new ArrayList<>();


        int b_l = B.length;
        //保存每个字母需求的最大值
        //这里是优化点
        int[] c26 = new int[26];
        for (int i = 0; i < b_l; i++) {
            char[] chars = B[i].toCharArray();
            int[] temp = new int[26];
            for (char c : chars) {
                temp[c - 'a']++;
            }
            for (int x = 0; x < 26; x++) {
                if (temp[x] > c26[x]) {
                    c26[x] = temp[x];
                }
            }
        }


        for (int i = 0; i < length; i++) {
            boolean isOk = true;
            for (int j = 0; j < 26; j++) {
                if (cache[i][j] < c26[j]) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                ans.add(A[i]);
            }
        }

        return ans;

    }
}
