package com.go2going.leetcode;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_719<br>
 * 描述：对于第一次接触bs，看不懂，但是明白之后就看懂了，好了好长时间啊，crying！！！
 *
 * @author wangqiang
 * 创建时间：  2017/11/6 0006 12:57
 */
public class LeetCode_719 {


    /**
     * n*(n-1)/2个对
     * 470ms，桶排序
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {


        Arrays.sort(nums);

        int maxLength = nums[nums.length - 1];//最大距离

        int[] length = new int[maxLength + 1];//距离出现的次数

        //枚举每个距离
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                length[nums[j] - nums[i]]++;
            }
        }


        //length的index就是距离，所以只要累加和>=k就找到了，桶排序原理
        for (int i = 0, sum = 0; i < length.length; i++) {
            sum += length[i];
            if (sum >= k) {
                return i;
            }
        }
        return 0;
    }


    // 获取数组中差值的绝对值小于或等于mid的个数
    private int countPairs(int[] a, int mid) {
        int n = a.length, res = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (j < n && a[j] - a[i] <= mid) j++;
            res += j - i - 1;//每次for开始时都会和自己比较，所以在这减一
        }
        return res;
    }

    /**
     * 33.84%  308ms
     * @param a
     * @param k
     * @return
     */
    public int smallestDistancePair3(int a[], int k) {
        int n = a.length;

        //二分查找的前提是有序
        Arrays.sort(a);

        // 最小距离
        int low = a[1] - a[0];
        for (int i = 1; i < n - 1; i++)
            low = Math.min(low, a[i + 1] - a[i]);

        // 最大距离
        int high = a[n - 1] - a[0];

        // 二分查找，折半的是距离
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(a, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            System.out.println(i);
        }
    }
}
