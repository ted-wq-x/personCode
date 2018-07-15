package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author BlueT
 * 2018/7/15 16:17
 */
public class LeetCode_784 {
    /**
     * 28ms
     * @param S
     * @return
     */
    public List<String> letterCasePermutation(String S) {
        Deque<StringBuilder> stringDeque = new ArrayDeque<>();
        char[] chars = S.toCharArray();
        stringDeque.push(new StringBuilder());
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            int size = stringDeque.size();
            for (int i = 0; i < size; i++) {
                StringBuilder pop = stringDeque.pop();
                if (c >= 'a') {
                    String c1 = (c + "").toUpperCase();
                    stringDeque.addLast(new StringBuilder().append(pop).append(c1));
                } else if (c >= 'A') {
                    String c1 = (c + "").toLowerCase();
                    stringDeque.addLast(new StringBuilder().append(pop).append(c1));
                }
                stringDeque.addLast(new StringBuilder().append(pop).append(c));

            }
        }
        List<String> ans = new ArrayList<>(stringDeque.size());
        for (StringBuilder builder : stringDeque) {
            ans.add(builder.toString());
        }
        return ans;
    }

    public List<String> letterCasePermutation2(String S) {
        List<String> ans = new ArrayList<>();

        dfs(S.toCharArray(), 0, ans);
        return ans;
    }

    public static void dfs(char[] array, int index, List<String> ans) {
        if (index == array.length) {
            ans.add(new String(array));
            return;
        }

        if (array[index] >= 'a') {
            array[index] -= 32;
            dfs(array, index + 1, ans);
            array[index] += 32;
        } else if (array[index] >= 'A') {
            array[index] += 32;
            dfs(array, index + 1, ans);
            array[index] -= 32;
        }

        dfs(array,index+1,ans);
    }

    public static void main(String[] args) {
        LeetCode_784 leetCode_784=new LeetCode_784();
        List<String> a1b2 = leetCode_784.letterCasePermutation2("a1b2");
        System.out.println(a1b2.size());
    }

}
