package com.go2going.leetcode;

import java.util.*;

public class LeetCode_855 {

    public static void main(String[] args) {
        ExamRoom room = new ExamRoom(10);
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        room.leave( 4);
        System.out.println(room.seat());
    }
}
class ExamRoom {



    private int max;
    private TreeSet<Integer> sets=new TreeSet<>();

    public ExamRoom(int N) {
        max = N;
    }

    /**
     * 每次插入都计算一下新的座位
     * @return
     */
    public int seat() {
        int ans = 0;

        if (!sets.isEmpty()) {
            int pre = 0;
            int maxLength = 0;
            //检查第一个座位
            if (!sets.contains(0)) {
                maxLength = sets.first();
            }
            Iterator<Integer> iterator = sets.iterator();
            while (iterator.hasNext()) {
                Integer x = iterator.next();
                int len = (x - pre)/2 ;//计算出两个位置之间的座位到最近一个人的距离，不能只计算两个直接的距离（有特殊情况无法考虑在内）
                if (len > maxLength) {
                    maxLength = len;
                    ans = (x + pre) / 2;
                }
                pre = x;
            }

            //检查最后一个座位
            if (!sets.contains(max - 1)) {
                int len = max - 1 - sets.last();
                if (len > maxLength) {
                    ans= max - 1;
                }
            }
        }
        sets.add(ans);
        return ans;
    }

    public void leave(int p) {
        sets.remove(p);
    }
}