package com.go2going.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_929 {
    /**
     * easy
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set=new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            String localName = split[0];
            int i = localName.indexOf("+");
            if (i != -1) {
                localName = localName.substring(0, i);
            }
            localName = localName.replaceAll("\\.", "");
            set.add(localName + "@" + split[1]);
        }
        return set.size();
    }
}
