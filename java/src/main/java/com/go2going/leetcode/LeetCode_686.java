package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_686<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/8 0008 15:48
 */
public class LeetCode_686 {
    /**
     * 168ms
     *
     * @param A
     * @param B
     * @return
     */
    public int repeatedStringMatch(String A, String B) {
        int al = A.length();
        int bl = B.length();

        int l;
        if (bl % al == 0) {
            l = bl / al;
        } else {
            l = bl / al + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < l; j++) {
            sb.append(A);
        }

        if (sb.toString().contains(B)) {
            return l;
        }

        sb.append(A);
        if (sb.toString().contains(B)) {
            return l + 1;
        }


        return -1;

    }


    /**
     * 不行，长的字符串超时
     * @param A
     * @param B
     * @return
     */
    public int repeatedStringMatch1(String A, String B) {


        char[] ca = A.toCharArray();
        char[] cb = B.toCharArray();
        int lena = ca.length;
        int lenb = cb.length;

        int l;
        if (lenb % lena == 0) {
            l = lenb / lena;
        } else {
            l = lenb / lena + 1;
        }


        int maxLen = lena * (l + 1);
        for (int j = 0; j < maxLen-lenb; j++) {
            for (int i = j; i < j + lenb; i++) {
                if (ca[i %lena] != cb[i-j]) {
                    break;
                }
                if (i == j + lenb-1) {
                    return maxLen - j -lenb< lena ? l + 1 : l;
                }
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        LeetCode_686 leetCode_686 = new LeetCode_686();

        System.out.println(leetCode_686.repeatedStringMatch1("abcd", "cdabcdab"));
    }
}
