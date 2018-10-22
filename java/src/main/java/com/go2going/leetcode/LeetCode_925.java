package com.go2going.leetcode;

public class LeetCode_925 {
    public boolean isLongPressedName(String name, String typed) {
        char[] pre = name.toCharArray();
        char[] cur = typed.toCharArray();
        int preLength = pre.length;
        int curLength = cur.length;
        int i = 0, j = 0;
        while (i < preLength) {
            if (j == curLength) {
                return false;
            }
            if (pre[i] == cur[j]) {
                i++;
                j++;
            } else {
                if (i == 0) {
                    return false;
                }
                if (cur[j] == pre[i - 1]) {
                    j++;
                } else {
                    return false;
                }
            }
        }

        return true;

    }
}
