package com.go2going.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author BlueT
 * 2017/12/16 19:39
 */
public class LeetCode_17 {
    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] chars = digits.toCharArray();
        int length = chars.length;
        LinkedList<String> ans = new LinkedList<>();
        if (length == 0) {
            return ans;
        }

        //为第一次循环判断做准备
        ans.push("");

        for (int i = 0; i < length; i++) {

            int numericValue = chars[i]-'0';
            String s = mapping[numericValue];
            char[] chars1 = s.toCharArray();
            int length1 = chars1.length;
            //取出目前队列中所有元素
            while (ans.peek().length() == i) {
                String remove = ans.remove();
                for (int i1 = 0; i1 < length1; i1++) {
                    ans.add(remove+chars1[i1]);
                }

            }
        }

        return ans;

    }
}
