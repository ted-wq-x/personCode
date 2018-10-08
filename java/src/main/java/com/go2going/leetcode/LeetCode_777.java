package com.go2going.leetcode;

public class LeetCode_777 {

    public boolean canTransform(String start, String end) {
        int length = start.length();
        if (length % 2 != 0) {
            return false;
        }
        char[] sc = start.toCharArray();
        char[] ec = end.toCharArray();
        int p1 = 0, p2 = 0;
        while (p1 < length && p2 < length) {

            // 找到第一个不是X的index
            while (p1 < length && sc[p1] == 'X') {
                p1++;
            }
            while (p2 < length && ec[p2] == 'X') {
                p2++;
            }

            if (p1 == length && p2 == length) {
                return true;
            }

            if (p1 == length || p2 == length) {
                return false;
            }

            if (sc[p1] != ec[p2]) {
                return false;
            }

            // 这个判断很重要
            if (sc[p1] == 'L' && p1 < p2) {
                return false;
            }

            if (sc[p1] == 'R' && p1 > p2) {
                return false;
            }
            p1++;
            p2++;

        }


        return true;

    }

}
