package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_409<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/20 0020 10:06
 */
public class LeetCode_409 {
    /**
     * 25ms
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;
        boolean isFirst = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer integer = map.get(c);
            if (integer == null) {
                integer = 0;
            }
            map.put(c, integer+1);
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (!isFirst&&characterIntegerEntry.getValue() % 2 == 1) {
                sum++;
                isFirst = true;
            }

            sum += (characterIntegerEntry.getValue() / 2)<<1;
        }

        return sum;
    }

    /**
     * 9ms
     * @param s
     * @return
     */
    public int longestPalindrome1(String s) {

        int sum = 0;
        boolean isFirst = false;
        int[] ints = new int[58];

        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'A']++;
        }

        for (int anInt : ints) {
            if (!isFirst&&anInt % 2 == 1) {
                sum++;
                isFirst = true;
            }
            sum += (anInt / 2)<<1;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("A---"+(int)'A');
        System.out.println("Z---"+(int)'Z');
        System.out.println("Z---"+(int)'Z');
    }
}
