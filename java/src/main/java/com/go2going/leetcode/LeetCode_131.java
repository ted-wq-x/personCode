package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_131<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/23 0023 10:17
 */
public class LeetCode_131 {
    List<List<String>> lists = new ArrayList<>();

    /**
     * 递归+回溯算法
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        go(new ArrayList<>(), chars, 0);
        return lists;
    }

    /**
     * 判断子字符串是否是回文数
     * @param list
     * @param chars
     * @param start
     */
    private void go(List<String> list,  char[] chars ,int start) {
        //边界
        if (start >= chars.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < chars.length; i++) {
            if (idPalindrome(chars, start, i)) {
                list.add(new String(Arrays.copyOfRange(chars, start, i+1)));
                go(list, chars, i + 1);
                list.remove(list.size() - 1);//backTrace
            }
        }
    }


    /**
     * 判断是否为回文数
     * @param chars
     * @param start
     * @param end
     * @return
     */
    private boolean idPalindrome(char[] chars, int start, int end) {
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
