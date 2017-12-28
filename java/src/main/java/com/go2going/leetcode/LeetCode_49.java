package com.go2going.leetcode;

import java.util.*;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_49<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/28 0028 17:20
 */
public class LeetCode_49 {

    /**
     * 存在超时的风险，64%
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();

        Map<String, List<String>> listMap = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> strings = listMap.get(s);
            if (strings== null) {
                strings = new ArrayList<>();
            }
            listMap.put(s, strings);
            strings.add(str);
        }

        lists.addAll(listMap.values());
        return lists;
    }
}
