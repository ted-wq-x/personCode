package com.go2going.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author BlueT
 * 2018/1/28 16:30
 */
public class LeetCode_139 {
    Map<String, Boolean> map = new HashMap<>();

    /**
     * 没啥思路，是用记忆化递归
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (wordDict.contains(s)) {
            map.put(s, true);
            return true;
        }

        int length = s.length();

        for (int i = 1; i < length; i++) {
            //固定一部分
            if (wordDict.contains(s.substring(i)) && wordBreak(s.substring(0, i), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
