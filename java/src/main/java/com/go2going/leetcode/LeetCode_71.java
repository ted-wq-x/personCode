package com.go2going.leetcode;

import java.util.LinkedList;

public class LeetCode_71 {

    /**
     * 思路：使用队列，主要难点在于几种特殊情况，如“.”
     * @param path
     * @return
     */
    public String simplifyPath(String path) {

        LinkedList<String> linkedList = new LinkedList();
        StringBuilder sb = new StringBuilder();

        String[] split = path.split("/");

        for (String s : split) {
            if (s.equals("..")) {
                if(!linkedList.isEmpty()) {
                    linkedList.removeLast();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                linkedList.add(s);
            }
        }

        sb.append("/");

        for (String s : linkedList) {
            sb.append(s).append("/");
        }

        return !linkedList.isEmpty()?sb.delete(sb.length() - 1, sb.length()).toString():sb.toString();

    }
}
