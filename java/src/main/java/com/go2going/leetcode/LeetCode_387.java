package com.go2going.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author BlueT
 * 2017/11/4 21:38
 */
public class LeetCode_387 {

    public int firstUniqChar(String s) {
        char[] charNum = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : charNum) {
            Integer integer = map.get(c);
            if (integer == null) {
                map.put(c, 1);
            } else {
                map.put(c, integer + 1);
            }
        }
        for (Map.Entry<Character, Integer> c : map.entrySet()) {
            if (c.getValue() == 1) {
                return s.indexOf(c.getKey());
            }
        }
        return -1;
    }

    /**
     * 最快的，
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        char[] charNum = s.toCharArray();
        int length = charNum.length;
        int sum = length;
        for (char i='a';i<='z';i++) {
            int i1 = s.indexOf(i);

            //判断出现的位置是否相等
            if (i1 != -1 && s.lastIndexOf(i) == i1) {
                if (i1 < sum) {
                    sum = i1;
                }
            }
        }
        return sum==length?-1:sum;
    }

    public static void main(String[] args) {
        LeetCode_387 leetCode_387 = new LeetCode_387();
        System.out.println(leetCode_387.firstUniqChar1("leetcode"));
    }
}
