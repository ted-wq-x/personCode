package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_229 {
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        int threshold = length / 3;
        Arrays.sort(nums);
        List<Integer> ans=new ArrayList<>();
        Integer pre=null;
        int count = 1;
        for (int i = 0; i < length; i++) {
            if (pre == null) {
                pre = nums[i];
            } else {
                if (pre == nums[i]) {
                    count++;
                } else {
                    if (count > threshold) {
                        ans.add(pre);
                    }
                    count = 1;
                    pre = nums[i];
                }
            }

        }

        if (count > threshold&&pre!=null) {
            ans.add(pre);
        }
        return ans;


    }

    public static void main(String[] args) {
        LeetCode_229 leetCode_229=new LeetCode_229();

        System.out.println(Arrays.toString(leetCode_229.majorityElement(new int[]{3, 2, 3}).toArray()));
    }
}
