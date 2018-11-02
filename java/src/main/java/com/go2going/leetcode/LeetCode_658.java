package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_658 {

    /**
     * 二分查找，关键是查找的条件，普通的查找都是mid=target
     *
     * @param arr
     * @param k
     * @param x
     * @return 返回的数组其实是一个长度为k的连续子数组
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int length = arr.length;

        int left = 0, right = length - k;

        while (left < right) {
            //这个mid表示，子数组的起始位置，所以right不会超过length-k
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                //TODO 为什么+1，而下面不-1
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            ans.add(arr[left + i]);
        }
        return ans;

    }

    /**
     * 这个很好理解，找到x的位置，比较左右两个数取最近的就行
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        // 找到位置
        int index = Arrays.binarySearch(arr, x);
        if (index < 0) {
            //配找到的话，转化成插入的位置
            index = -(index + 1);
        }

        int left = index - 1, right = index ;
        while (k-- > 0) {
            if (left < 0 || (right < arr.length && x - arr[left] > arr[right] - x)) {
                right++;
            } else {
                left--;
            }
        }
        List<Integer> ans = new ArrayList<>();

        for (int i = left+1; i <right; i++) {
            ans.add(arr[ i]);
        }
        return ans;

    }
}
