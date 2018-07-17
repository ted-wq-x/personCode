package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_854 {
    private static int dfs(char[] a, char[] b, int start) {
        if (start == a.length) {
            return 0;
        }

        if (a[start] == b[start]) {
            return dfs(a, b, start + 1);
        }

        int min = Integer.MAX_VALUE;


        //start出不相同
        for (int i = start + 1; i < a.length; i++) {
            //后面的判断，是保证不能是第一步中的工作给废了
            if (a[i] == b[start] && a[i] != b[i]) {
                swap(a, i, start);
                min = Math.min(1 + dfs(a, b, start + 1), min);
                swap(a, i, start);//恢复原状
                //如果复现了1中两个可以直接交换的情况，那么久找到这次dfs的最小值
                if (a[start] == b[i]) {
                    return min;
                }
            }
        }

        return min;


    }

    /**
     * 交换两个字符都相同的
     *
     * @param a
     * @param b
     * @return
     */
    private static int swapSameC(char[] a, char[] b) {

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                continue;
            }
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == b[j] && a[j] == b[i]) {
                    swap(a, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void swap(char[] a, int x, int y) {
        char c = a[x];
        a[x] = a[y];
        a[y] = c;
    }

    private static int go(Map<String, Integer> map, int start, String B, char[] chars) {
        String s = new String(chars);
        if (s.equals(B)) {
            return 0;
        }

        Integer integer = map.get(s);
        if (integer != null) {
            return integer;
        }

        int i = start;
        for (; i < chars.length; i++) {
            if (chars[i] != B.charAt(i)) {
                break;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j < chars.length; j++) {
            if (chars[j] == B.charAt(i)) {
                swap(chars, i, j);
                min = Math.min(1 + go(map, start + 1, B, chars), min);
                swap(chars, i, j);
            }
        }

        map.put(s, min);

        return min;
    }

    public int kSimilarity(String A, String B) {

        if (A.equals(B)) {
            return 0;
        }

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        // 1. 交换两个字符相同的
        int count = swapSameC(a, b);

        // 2. 交换剩下需要交换的，dfs，因为交换之后有可能出现1的情况，

        count += dfs(a, b, 0);


        return count;

    }

    /**
     * 记忆化递归
     *
     * @param A
     * @param B
     * @return
     */
    public int kSimilarity2(String A, String B) {

        Map<String, Integer> map = new HashMap<>();


        return go(map, 0, B, A.toCharArray());

    }
}
