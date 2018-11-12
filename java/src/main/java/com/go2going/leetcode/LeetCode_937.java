package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_937 {
    public String[] reorderLogFiles(String[] logs) {

        List<String> letter=new ArrayList<>();
        List<String> digit = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];

            String[] s = log.split(" ");
            String s1 = s[1];
            char[] chars = s1.toCharArray();
            boolean isDigit = true;
            for (char aChar : chars) {
                if (!Character.isDigit(aChar)) {
                    isDigit = false;
                    break;
                }
            }
            if (isDigit) {
                digit.add(log);
            } else {
                letter.add(log);
            }
        }

        letter.sort((o1, o2) -> {
            String s1 = o1.split(" ")[0];
            String s2 = o2.split(" ")[0];
            return o1.substring(s1.length()).compareTo(o2.substring(s2.length()));
        });

        String[] ans=new String[logs.length];
        int size = letter.size();
        for (int i = 0; i < size; i++) {
            ans[i] = letter.get(i);
        }

        for (int i = 0; i < digit.size(); i++) {
            ans[size + 1 + i] = digit.get(i);
        }

        return ans;
    }
}
