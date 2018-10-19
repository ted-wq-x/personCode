package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_922 {
    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;

        ArrayDeque<Integer> odd = new ArrayDeque<>();
        ArrayDeque<Integer> even = new ArrayDeque<>();

        List<Integer> index = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (A[i] % 2 != i % 2) {
                if (i % 2 == 0) {
                    //value is even
                    even.add(A[i]);
                } else {
                    odd.add(A[i]);
                }
                index.add(i);

            }
        }

        for (Integer i : index) {
            if (i % 2 == 0) {
                A[i] = odd.pop();
            } else {
                A[i] = even.pop();

            }
        }
        return A;
    }


    public int[] sortArrayByParityII2(int[] A) {
        int length = A.length;
        int[] result = new int[length];

        int odd = 0, even = 1;


        for (int i = 0; i < length; i++) {
            if (A[i] % 2 == 0) {
                result[odd] = A[i];
                odd += 2;
            } else {
                result[even] = A[i];
                even += 2;
            }
        }



        return result;
    }
}
