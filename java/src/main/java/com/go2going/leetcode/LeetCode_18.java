package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author BlueT
 * 2017/12/16 20:05
 */
public class LeetCode_18 {
    /**
     * 多加的判断条件极大的提高了速度
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;

        List<List<Integer>> lists = new ArrayList<>();

        if (nums.length < 4) {
            return lists;
        }

        Arrays.sort(nums);

        for (int i = 0; i < length - 3; i++) {
            int a1 = nums[i];
            if (a1 + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (a1 + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) continue;
            if (i > 0 && a1 == nums[i - 1]) {
                continue;
            }
            for (int i2 = i + 1; i2 < length - 2; i2++) {
                int a2 = nums[i2];
                if (a1 + a2 + nums[i2 + 1] + nums[i2 + 2] > target) break;
                if (a1 + a2 + nums[length - 1] + nums[length - 2] < target) continue;
                if (a2 == nums[i2 - 1] && i2 > i + 1) {
                    continue;
                }
                int start = i2 + 1, end = length - 1;
                while (start < end) {
                    int i1 = nums[start] + nums[end] + a1 + a2;
                    if (i1 == target) {
                        lists.add(Arrays.asList(a1, a2, nums[start], nums[end]));

                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        start++;
                        end--;
                    } else if (target > i1) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return lists;
    }
}
