package com.go2going.leetcode;

public class LeetCode_796 {
    public boolean rotateString(String A, String B) {
        char[] Ac = A.toCharArray();
        int length = Ac.length;

        if (A.equals(B)) {
            return true;
        }

        StringBuilder asb=new StringBuilder().append(A);
        for (int i = 0; i < length; i++) {
            asb.deleteCharAt(0);
            asb.append(Ac[i]);
            if (asb.toString().equals(B)) {
                return true;
            }
        }

        return false;

    }

    public boolean rotateString1(String A, String B) {
        int length = A.length();

        if (A.equals(B)) {
            return true;
        }
        if (length != B.length()) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (A.substring(0, i).equals(B.substring(length - i))
                    && A.substring(i).equals(B.substring(0, length - i))) {
                return true;
            }
        }

        return false;

    }
}
