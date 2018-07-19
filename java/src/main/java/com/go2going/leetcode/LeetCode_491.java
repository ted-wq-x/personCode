package com.go2going.leetcode;

import java.util.*;

public class LeetCode_491 {
    /**
     * 13ms
     * @param ans
     * @param temp
     * @param nums
     * @param start
     */
    private static void go(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        int length = nums.length;
        if (temp.size() >= 2) {
            ans.add(new ArrayList<>(temp));
        }
        if (start == length) {
            return;
        }
        int size = temp.size();
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < length; i++) {
            Integer num = nums[i];
            //保证递增
            if (size != 0 && nums[i] < temp.get(size - 1)) {
                continue;
            }
            //去重
            if (set.contains(num)) {
                continue;
            }
            set.add(num);
            temp.add(num);
            go(ans, temp, nums, i + 1);
            temp.remove(num);

        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 2) {
            return ans;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        go(ans, temp, nums, 0);

        return ans;
    }

    public static void main(String[] args) {
        LeetCode_491 leetCode_491=new LeetCode_491();

        System.out.println(leetCode_491.findSubsequences(new int[]{1, 2, 1, 1}));
    }
}
