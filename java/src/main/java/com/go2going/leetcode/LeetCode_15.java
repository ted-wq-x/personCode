package com.go2going.leetcode;

import java.util.*;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_15<br>
 * 描述：3Sum
 *
 * @author wangqiang
 * 创建时间：  2017/12/11 0011 13:16
 */
public class LeetCode_15 {

    /**
     * 找到说有的三元组和为0，不包含重复的，74ms
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();

        int length = nums.length;
        Integer bef1 = null;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num > 0) {
                break;
            }
            if (bef1 != null && bef1 == num) {
                continue;
            } else {
                bef1 = num;
            }
            int l = i + 1, r = length - 1, s = -num;

            while (l < r) {
                if (nums[l] + nums[r] == s) {
                    ret.add(Arrays.asList(num, nums[l], nums[r]));
                    //去除重复的
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[l-1]) {
                        r--;
                    }
                    l++;r--;
                } else if (nums[l] + nums[r] > s) {
                    r--;
                } else {
                    l++;
                }
            }

        }
        return ret;
    }


    //5057 ,对第三个数使用二分查找，很慢
    public boolean isOk(int[] str, int l, int r, int val) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (str[mid] > val) {
                r--;
            } else if (str[mid] < val) {
                l++;
            } else {
                return true;
            }
        }

        return false;
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public static void main(String[] args) {
        LeetCode_15 leetCode_15 = new LeetCode_15();
        System.out.println(tableSizeFor(20));
    }
}
