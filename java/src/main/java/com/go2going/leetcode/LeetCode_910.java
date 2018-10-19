package com.go2going.leetcode;

import java.util.Arrays;

/**
 * Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).
 * <p>
 * After this process, we have some array B.
 * <p>
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 */
public class LeetCode_910 {
    public static void main(String[] args) {
        LeetCode_910 leetCode_910 = new LeetCode_910();
        System.out.println(leetCode_910.smallestRangeII(new int[]{4, 7, 4}, 4));
    }

    /**
     * greedy
     *
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeII(int[] A, int K) {
        //将数组从小到大排序
        Arrays.sort(A);
        int min = A[A.length - 1] - A[0];

        //求最大值和最小值的差y，并使y取min
        for (int i = 1; i < A.length; i++) {

            // 思路是，在排序完之后，只要使得最小值+K，最大值-K，那么其差值就会是min
            // greedy去计算最大值和最小值，保留min（h-l）
            // 最小值
            int l = Math.min(A[0] + K, A[i] - K);
            int h = Math.max(A[A.length - 1] - K, A[i - 1] + K);
            min = Math.min(min, h - l);
        }

        return min;
    }

    /**
     * Sort the vector.
     * Assuming there is a point, on the left of the point, all elements add K, on the right of the point,
     * all elements substract K, check each possible point. (a point is between two numbers).
     *
     * @param A
     * @param K
     * @return
     */
    public int smallestRangeII2(int[] A, int K) {
        //将数组从小到大排序
        Arrays.sort(A);
        int res = A[A.length - 1] - A[0];
        int left = A[0] + K, right = A[A.length - 1] - K;
        for (int i = 0; i < A.length - 1; i++) {
            int maxi = Math.max(A[i] + K, right), mini = Math.min(left, A[i + 1] - K);
            res = Math.min(res, maxi - mini);
        }
        return res;

    }


}
