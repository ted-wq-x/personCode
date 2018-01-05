package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_33<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/5 0005 9:03
 */
public class LeetCode_33 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int index = -1;

        for (int i = 1; i < length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < nums[i - 1]) {
                index = i;
                break;

            }
        }


        if (index != -1) {
            if (target > nums[index]) {
                if (nums[length - 1] < target) {
                    return binarySearch(nums, target, 0, index - 1);
                } else if (nums[length - 1] == target) {
                    return length - 1;
                } else {
                    return binarySearch(nums, target, index, length - 1);
                }

            } else if (target == nums[index]) {
                return index;
            } else {
                return binarySearch(nums, target, 0, index - 1);
            }
        } else {
            return binarySearch(nums, target, 0, length - 1);
        }

    }

    /**
     * 这个想法有点难度，但是性能比我的那个那好
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            //只要mid《right那么在这之间的肯定是自增的
            if (nums[mid] < nums[right]) {
                //判断值在这个区间
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                //不在这个区间
                else right = mid - 1;
            } else {
                //中间存在旋转的点
                //判断不在这个区间的条件，那么左边的区间肯定是自增的
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }


    private static int binarySearch(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        LeetCode_33 leetCode_33 = new LeetCode_33();

        System.out.println(leetCode_33.search(new int[]{3, 1}, 1));
    }
}
