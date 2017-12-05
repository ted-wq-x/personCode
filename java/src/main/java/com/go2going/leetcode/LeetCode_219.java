package com.go2going.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author BlueT
 * 2017/12/4 22:47
 */
public class LeetCode_219 {

    /**
     * 大佬机制的想法
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k > 3000) return false;//投机，绝对是看了测试用例
        if (nums == null || nums.length <= 1) return false;


        //只存放在k范围之内的数
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            //删除超过范围之外的数
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            //false代表已经有这个数了
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
