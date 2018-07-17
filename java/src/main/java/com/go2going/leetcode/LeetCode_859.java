package com.go2going.leetcode;

public class LeetCode_859 {
    /**
     * 99%
     * @param A
     * @param B
     * @return
     */
    public boolean buddyStrings(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        if (a.length != b.length) {
            return false;
        }

        int pre = -1,count=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                if (pre != -1) {
                    if (a[pre] == b[i] && a[i] == b[pre]) {

                    } else {
                        return false;
                    }
                } else {
                    pre = i;
                }
                count++;
            }
        }
        if (count > 2) {
            return false;
        } else if (count == 2) {
            return true;
        } else if (count == 1) {
            return false;
        } else if (count == 0) {
            //    判断是否有相同的字母

            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] == a[j]) {
                        return true;
                    }
                }
            }
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        LeetCode_859 leetCode_589=new LeetCode_859();
        System.out.println(leetCode_589.buddyStrings("ab", "ba"));
    }
}
