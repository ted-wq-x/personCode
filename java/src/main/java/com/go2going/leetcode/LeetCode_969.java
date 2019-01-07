package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();
        int length = A.length;
        for (int i = length-1; i >0 ; i--) {
            int index = findMaxValueIndex(A, i);
            if (index == i) {
                continue;
            }
            if (index != 0) {
                reverse(A, index);
                ans.add(index+1);
            }
            reverse(A, i);
            ans.add(i+1);
        }

        return ans;
    }

    private int findMaxValueIndex(int[] array, int end) {
        int index = 0;
        int value = -1;
        for (int i = 0; i <= end; i++) {
            if (array[i] >= value) {
                index=i;
                value = array[i];
            }
        }
        return index;
    }

    private void reverse(int[] array, int end) {
        int start = 0, env = end;
        while (start < env) {
            int temp = array[start];
            array[start] = array[env];
            array[env] = temp;
            start++;
            env--;
        }
    }

    public static void main(String[] args) {
        LeetCode_969 leetCode_969=new LeetCode_969();
        ;
        System.out.println(leetCode_969.pancakeSort(new int[]{1,2,3}));
    }
}
