package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_34<br>
 * 描述：难点在于O(logn)
 *
 * @author wangqiang
 * 创建时间：  2017/12/26 0026 15:49
 */
public class LeetCode_34 {
    /**
     * 我忽略了升序这个条件
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;

        int start = -1, end = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }
        if (end == -1) {
            end = start;
        }
        return new int[]{start, end};
    }

    public int[] searchRange1(int[] nums, int target) {
        int length = nums.length;

        int start = binarySearchFirstGreater(nums, target, 0, length);

        if (start == length || nums[start] != target) {
            return new int[]{-1, -1};
        }


        //注意-1，因为是整数，所以当不存在是就是第一个数，-1，可定是我们想要的，这里的+1和-1是难点
        return new int[]{start, binarySearchFirstGreater(nums, target + 1, start + 1, length) - 1};
    }

    /**
     * 找到第一个比target大的数
     *
     * @param a
     * @param target
     * @param l
     * @param r
     * @return
     */
    static int binarySearchFirstGreater(int[] a, int target, int l, int r) {
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            //这里也是难点
            if (target > a[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
