package com.go2going.leetcode;

import java.util.Arrays;

/**
 * @author BlueT
 * 2019/1/13 12:22
 */
public class LeetCode_976 {
    public int largestPerimeter(int[] A) {
        int max = 0;

        int length = A.length;

        Arrays.sort(A);

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    int a = A[i] + A[j] + A[k];
                    if (a <= max) {
                        break;
                    }
                    if (isTriangle(A[i], A[j], A[k])) {
                        max = a;
                    } else {
                        break;
                    }
                }
            }
        }

        return max;

    }
    public int largestPerimeter2(int[] a) {
        Arrays.sort(a);

        for (int i = a.length - 1; i >= 2; i--) {
            if (a[i] >= a[i -1] + a[i -2]) {
                continue;
            }
            return a[i] + a[i -1] + a[i -2];
        }

        return 0;

    }


    private boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
