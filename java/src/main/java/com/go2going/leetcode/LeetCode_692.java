package com.go2going.leetcode;

import java.util.*;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_692<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/23 0023 9:39
 */
public class LeetCode_692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> returnStr = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String>[] temp = new List[words.length + 1];

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer integer = entry.getValue();
            if (temp[integer] == null) {
                temp[integer] = new ArrayList<>();
            }
            temp[integer].add(entry.getKey());
        }

        for (int i = temp.length - 1; i >= 0; i--) {
            List<String> list = temp[i];
            if (list != null) {
                Collections.sort(list);
                for (String s : list) {
                    if (returnStr.size() < k) returnStr.add(s);
                }
            }
        }

        return returnStr;
    }


    public List<String> topKFrequent1(String[] words, int k) {
        List<String> returnStr = new ArrayList<>();

        //进行按照字母排序,从大到小
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> Objects.equals(a.getValue(), b
                .getValue()) ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            //加元素，删除多余的
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }


        while (!queue.isEmpty()) {
            returnStr.add(0, queue.poll().getKey());
        }


        return returnStr;
    }
}
