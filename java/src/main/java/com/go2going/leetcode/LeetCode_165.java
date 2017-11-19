package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/11/18 22:14
 */
public class LeetCode_165 {

    /**
     * 题目的意思是'.'符号设个分隔符,找到第一个不相等的就行
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {

        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");


        int length1 = s1.length;
        int length2 = s2.length;
        int length = Math.max(length1, length2);

        for (int i = 0; i < length; i++) {
            Integer i1 = i < length1 ? Integer.valueOf(s1[i]) : 0;
            Integer i2 = i < length2 ? Integer.valueOf(s2[i]) : 0;
            int compare = i1.compareTo(i2);
            if (compare !=0) {
                return compare;
            }
        }

        return 0;
    }
}
