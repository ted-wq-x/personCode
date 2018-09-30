package com.go2going.leetcode;

import java.util.Arrays;
import java.util.List;

public class LeetCode_539 {

    private static final int MAX = 1440;

    /**
     * 暴力解法 36ms
     * @param timePoints
     * @return
     */
    public int findMinDifference(List<String> timePoints) {

        int length = timePoints.size();
        int[] a=new int[length];

        for (int i = 0; i < length; i++) {
            String s = timePoints.get(i);
            a[i] = getMin(s);
        }

        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length-1; i++) {
            int a1 = a[i + 1] - a[i];
            min = Math.min(Math.min(a1,MAX-a1), min);
        }

        int a1 = a[length-1] - a[0];
        min = Math.min(Math.min(a1,MAX-a1), min);

        return min;
    }

    private int getMin(String time){
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }


    /**
     * bucket 11ms
     * @param timePoints
     * @return
     */
    public int findMinDifference2(List<String> timePoints) {
        int min = Integer.MAX_VALUE;


        int total = 24 * 60;
        boolean[] mark = new boolean[total];
        int length = timePoints.size();

        for (int i = 0; i < length; i++) {
            String time = timePoints.get(i);
            String[] split = time.split(":");
            int i1 = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            //存在相同的时间，直接返回
            if (mark[i1]) return 0;
            mark[i1] = true;
        }

        int first = -1, last=-1,pre=-1;

        for (int i = 0; i < total; i++) {
            if (mark[i]) {
                if (first == -1) {
                    first = i;
                }

                if (pre != -1) {
                    min = Math.min(i - pre, min);
                }
                pre = i;
                last = i;
            }
        }

        return Math.min(min,total-last+first);
    }


    public static void main(String[] args) {
        LeetCode_539 leetCode_539=new LeetCode_539();
        System.out.println(leetCode_539.getMin("23:59"));
    }
}
