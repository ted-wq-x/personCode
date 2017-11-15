package com.go2going.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author BlueT
 * 2017/11/15 22:46
 */
public class LeetCode_321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] ans = new int[k];

        int l1 = nums1.length;
        int l2 = nums2.length;

        /**
         * 两个数组中，每个数组取的数量，不确定，所有需要循环
         */
        for (int i = 0; i <= k; i++) {
            int i2 = k - i;

            if (i > l1 || i2 > l2) {
                continue;
            }
            ans = max(ans, merge(getSome(nums1, i), getSome(nums2, i2)));
        }

        return ans;
    }


    /**
     * 两个最大数组合并
     *
     * @param ints1
     * @param ints2
     * @return
     */
    public int[] merge(Integer[] ints1, Integer[] ints2) {

        int i1 = ints1.length;
        int i2 = ints2.length;
        int[] arr = new int[i1 + i2];

        int i1Index = 0;
        int i2Index = 0;

        for (int i = 0; i < i1 + i2; i++) {
            if (i2Index >= i2 && i1Index < i1) {
                arr[i] = ints1[i1Index++];
            } else if (i2Index < i2 && i1Index >= i1) {
                arr[i] = ints2[i2Index++];
            } else {
                arr[i] = ints1[i1Index] > ints2[i2Index] ? ints1[i1Index++] : ints2[i2Index++];
            }
        }

        return arr;
    }


    /**
     * 取和最大的数组
     * @param ints
     * @param ints2
     * @return
     */
    public int[] max(int[] ints,int[] ints2) {
        int max = 0;
        for (int anInt : ints) {
            max += anInt;
        }

        int temp = 0;
        for (int i : ints2) {
            temp += i;
        }

        return max > temp ? ints : ints2;
    }


    /**
     * 生成最大数组
     * @param num
     * @param k
     * @return
     */
    public Integer[] getSome(int[] num, int k) {

        if (k == 0) {
            return new Integer[]{};
        }
        int canDropNum = num.length-k;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : num) {
            //最多能够舍弃的元素
            while (!list.isEmpty() && list.getLast() < i && canDropNum-- > 0) {
                list.removeLast();
            }

            list.add(i);
        }
        List<Integer> list1 = list.subList(0, k);
        Integer[] arr = new Integer[k];
        list1.toArray(arr);
        return arr;
    }
}
