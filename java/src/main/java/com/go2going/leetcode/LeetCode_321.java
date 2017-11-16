package com.go2going.leetcode;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=YYduNJfzWaA&t=329s
 * hard难度，使用了dp和greedy算法
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
    private int[] merge(int[] ints1, int[] ints2) {

        int i1 = ints1.length;
        int i2 = ints2.length;
        int[] arr = new int[i1 + i2];

        int i1Index = 0;
        int i2Index = 0;

        for (int i = 0; i < i1 + i2; i++) {
            if (geater(ints1, ints2, i1Index, i2Index)) {
                arr[i] = ints1[i1Index++];
            } else {
                arr[i] = ints2[i2Index++];
            }
        }

        return arr;
    }


    /**
     * 在相等的情况下，需要比较一下个值
     * @param ints1
     * @param ints2
     * @param index1
     * @param index2
     * @return 当ints1>ints2时，返回true
     */
    private boolean geater(int[] ints1, int[] ints2, int index1, int index2) {
        //数组都没有越界，且相等
        while (index1 < ints1.length && index2 < ints2.length && ints1[index1] == ints2[index2]) {
            index1++;
            index2++;
        }
        //不相等，但是得考虑index是否为length，当相等是，表示前面的数都是相等的，那么就取另一个
        return index2 == ints2.length || (index1 < ints1.length && ints1[index1] > ints2[index2]);
    }

    /**
     * 最大的数组，比较的是每一位上的值，如果相等就比较下一位，只要大就返回大的那个数组
     *
     * @param ints
     * @param ints2
     * @return
     */
    private int[] max(int[] ints, int[] ints2) {
        int length = ints.length;

        for (int i = 0; i < length; i++) {
            if (ints[i] == ints2[i]) {
                continue;
            } else if (ints[i] > ints2[i]) {
                return ints;
            } else {
                return ints2;
            }
        }

        return ints;
    }


    /**
     * 生成最大数组，dp算法
     *
     * @param num
     * @param k
     * @return
     */
    private int[] getSome(int[] num, int k) {

        if (k == 0) {
            return new int[]{};
        }

        //最多能丢弃的个数
        int canDropNum = num.length - k;
        // LinkedList<Integer> list = new LinkedList<>();
        // 使用数组效率高

        int[] arr = new int[num.length];
        int curIndex = 0;

        for (int i : num) {
            //最多能够舍弃的元素，有元素能够丢弃，最后一个元素小于i，丢弃的个数不能超过限制
            while (curIndex > 0 && arr[curIndex - 1] < i && canDropNum-- > 0) {
                arr[curIndex] = 0;
                curIndex--;
            }
            arr[curIndex++] = i;
        }

        //arr中的元素个数有可能大于k，取最前面几个
        int[] c = new int[k];
        System.arraycopy(arr, 0, c, 0, k);
        return c;
    }

    public static void main(String[] args) {
        LeetCode_321 leetCode_321 = new LeetCode_321();
        int[] ints = leetCode_321.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5);

        System.out.println(Arrays.toString(ints));
    }
}
