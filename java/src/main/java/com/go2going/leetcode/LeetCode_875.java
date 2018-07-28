package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_875 {
    private static int hour(int[] piles, int speed) {
        int length = piles.length;
        int hour = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (piles[i] <= speed) {
                hour += i + 1;
                break;
            } else {
                hour += (piles[i] / speed);
                hour += piles[i] % speed == 0 ? 0 : 1;
            }
        }
        return hour;
    }

    public static void main(String[] args) {
        LeetCode_875 leetCode_875 = new LeetCode_875();
        System.out.println(leetCode_875.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    /**
     * 24ms binary search
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        int length = piles.length;

        //sort 的花费不值当
        Arrays.sort(piles);
        int max = piles[length - 1];

        long sum = 0;
        for (int i = 0; i < length; i++) {
            sum += piles[i];
        }
        int min = (int) (sum / H );
        if (min == 0) {
            min = 1;
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (hour(piles, mid) <= H) {
                max = mid;
            } else {
                min = mid + 1;

            }
        }
        return min;
    }

    /**
     * 17ms
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed2(int[] piles, int H) {
        int length = piles.length;

        Arrays.sort(piles);

        long sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        int min = (int) (sum / H);
        if (min == 0) {
            min = 1;
        }
        while (true) {
            if (hour(piles, min) <= H) {
                return min;
            } min++;
        }

    }

    public int minEatingSpeed3(int[] piles, int H) {

        int length = piles.length;
        long sum = 0;
        for (int pile : piles) {
            sum += pile;
        }
        int min = (int) (sum / H);
        if (min == 0) {
            min = 1;
        }
        while (true) {
            int hour = 0;
            for (int i = 0; i < length; i++) {
                hour += piles[i] / min;
                hour += piles[i] % min == 0 ? 0 : 1;
            }
            if (hour <= H) {
                return min;
            } min++;
        }

    }
}
