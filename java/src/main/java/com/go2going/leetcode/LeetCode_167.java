package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个题非常有意思，在LeetCode的discuss中提到的解，在特定情况下都会超时
 * @author BlueT
 * 2017/11/4 19:37
 */
public class LeetCode_167 {
    public int[] twoSum(int[] numbers, int target) {

        int length = numbers.length;
        int[] re = new int[2];
        int[] ls = new int[2];
        int i1 = length - 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int temp = numbers[i];
            int s = target - temp;
            if (list.contains(s)) {
                continue;
            }
            for (int j = i+1; j < length; j++) {
                if (numbers[j] == s) {
                    if (s != temp) {
                        re[0] = i + 1;
                        re[1] = j + 1;
                        return re;
                    } else {
                        ls[0] = i + 1;
                        ls[1] = j + 1;
                    }
                }
                if (j == i1) {
                    list.add(s);
                }
            }
            list.add(temp);
        }
        if (re[0] == 0 && re[1] == 0) {
            return ls;
        }
        return re;
    }

    /**
     * 这个答案在特定情况下会超时，这个是其中的一个答案
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] ans = new int[2];
        if(numbers == null || numbers.length < 2)   return ans;
        int i = 0, j = numbers.length - 1;
        while(i <= j) {
            long tmp = numbers[i] + numbers[j];
            if(tmp == target) {
                ans[0] = i + 1;
                ans[1] = j + 1;
                return ans;
            }else if(tmp < target) {
                i++;
            }else {
                j--;
            }
        }
        return ans;
    }
}
