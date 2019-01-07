package com.go2going.leetcode;


import java.util.LinkedList;

public class LeetCode_967 {
    public static void main(String[] args) {
        LeetCode_967 leetCode_967 = new LeetCode_967();
        System.out.println(leetCode_967.numsSameConsecDiff(2, 1).length);
    }

    public int[] numsSameConsecDiff(int N, int K) {
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= 9; i++) {
            queue.push(i);
        }
        if (N == 1) {
            queue.push(0);
        }
        for (int i = 2; i <= N; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int pop = queue.pop();
                int last = pop % 10;
                for (int m = 0; m <= 9; m++) {
                    if (Math.abs(last - m) != K) {
                        continue;
                    }
                    queue.addLast(pop * 10 + m);
                }
            }
        }
        int size = queue.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = queue.pop();
        }

        return ans;
    }
}
