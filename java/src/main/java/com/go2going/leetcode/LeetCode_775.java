package com.go2going.leetcode;

public class LeetCode_775 {
    /**
     * brute force ,超时
     * @param A
     * @return
     */
    public boolean isIdealPermutation1(int[] A) {
        int length = A.length;
        int local = 0;
        int global = 0;
        for (int i = 0; i < length-1; i++) {
            if (A[i] > A[i + 1]) {
                local++;
            }
        }

        // time O(n^2)
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (A[i]>A[j]  && ++global > local) {
                    return false;
                }
            }
        }
        return global == local;
    }

    public boolean isIdealPermutation2(int[] A) {
        int length = A.length;
        int local = 0;
        int global = 0;
        for (int i = 0; i < length-1; i++) {
            if (A[i] > A[i + 1]) {
                local++;
            }
        }

       // TODO
        return global == local;
    }

    /**
     *  a local inversion is a global inversion, but a global one may not be local.
     *
     * global和local的区别在于，当前i的值
     * @param A
     * @return
     */
    public boolean isIdealPermutation3(int[] A) {
        int max = -1;
        int length = A.length;
        for (int i = 0; i < length - 2; i++) {
            max = Math.max(max, A[i]);
            if (max > A[i + 2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_775 leetCode_775=new LeetCode_775();
        boolean idealPermutation3 = leetCode_775.isIdealPermutation3(new int[]{5, 4, 6, 2, 1});
        System.out.println(idealPermutation3);
    }
}
