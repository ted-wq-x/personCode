package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_927 {
    /**
     * 3个部分，每个部分1的个数相同
     * 先找最右边的字符串，然后匹配左边和中间的
     * @param A
     * @return
     */
    public int[] threeEqualParts(int[] A) {

        int ones = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : A) {
            if (i == 1) {
                ones++;
                stringBuilder.append(1);
            } else {
                stringBuilder.append(0);
            }
        }
        if (ones == 0) {
            return new int[]{0,A.length-1};
        }
        String s1 = stringBuilder.toString();

        if (ones % 3 != 0) {
            return new int[]{-1,-1};
        }

        ones /= 3;

        int count = ones;

        int right = A.length - 1;
        StringBuilder sb=new StringBuilder();
        while (count > 0) {
            if (A[right--] == 1) {
                sb.append(1);
                count--;
            } else {
                sb.append(0);
            }
        }

        String s = sb.reverse().toString();


        int left = s1.indexOf(s);
        if (left == right + 1) {
            return new int[]{-1, -1};
        }

        int mid = s1.indexOf(s, left + s.length());
        if (mid == right + 1) {
            return new int[]{-1, -1};
        }

        return new int[]{left+s.length()-1,mid+s.length()};

    }

    public static void main(String[] args) {
        LeetCode_927 leetCode_927=new LeetCode_927();
        System.out.println(Arrays.toString(leetCode_927.threeEqualParts(new int[]{1, 0, 1, 0, 1})));
    }
}
