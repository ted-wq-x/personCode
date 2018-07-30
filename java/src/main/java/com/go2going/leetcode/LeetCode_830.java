package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        char[] c = S.toCharArray();

        int length = c.length;
        if (length < 3) {
            return ans;
        }

        char pre = c[0];

        int preIndex = 0;
        for (int i = 1; i < length; i++) {
            if (c[i] != pre) {
                if (i - preIndex >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(preIndex);
                    list.add(i-1);
                    ans.add(list);
                }

                preIndex = i;
                pre = c[i];

            }
        }

        if (length - preIndex >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(preIndex);
            list.add(length-1);
            ans.add(list);
        }


        return ans;
    }

    public static void main(String[] args) {
        LeetCode_830 leetCode_830=new LeetCode_830();
        System.out.println(leetCode_830.largeGroupPositions("abbxxxxzzy"));
    }
}
