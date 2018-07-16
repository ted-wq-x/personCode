package com.go2going.leetcode;

public class LeetCode_868 {
    public int binaryGap(int N) {
        String s = Integer.toBinaryString(N);
        char[] chars = s.toCharArray();

        int max = 0,preIndex=-1;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                if (preIndex != -1) {
                    max = Math.max(i - preIndex, max);
                }
                preIndex = i;
            }
        }
        return max;
    }
}
