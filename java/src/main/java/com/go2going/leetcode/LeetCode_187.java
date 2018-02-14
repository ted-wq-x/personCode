package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_187<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/14 0014 11:14
 */
public class LeetCode_187 {

    /**
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        // 存储所有的字符串
        Set<String> set = new HashSet<>();

        // 存放重复的
        Set<String> repeat = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String substring = s.substring(i, i + 10);
            if (!set.add(substring)) {
                repeat.add(substring);
            }
        }
        return  new ArrayList<>(repeat);
    }
}
