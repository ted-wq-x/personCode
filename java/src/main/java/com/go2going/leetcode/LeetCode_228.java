package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return ans;
        }
        int start = nums[0];
        int pre = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] == pre + 1) {
                pre = nums[i];
            } else {
                if (start == pre) {
                    ans.add(start+"");
                } else {
                    ans.add(start + "->" + pre);
                }
                start = nums[i];
                pre = nums[i];
            }
        }
        if (start == pre) {
            ans.add(start + "");
        } else {
            ans.add(start + "->" + pre);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
