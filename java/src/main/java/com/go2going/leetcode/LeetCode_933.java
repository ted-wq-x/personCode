package com.go2going.leetcode;

import java.util.ArrayDeque;

public class LeetCode_933 {

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
    static class RecentCounter {
        int count = 0;
        ArrayDeque<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            Integer poll = queue.peek();
            if (poll == null) {
                queue.addLast(t);
                count++;
                return 1;
            }
            if (t - poll <= 3000) {
                count++;
                queue.addLast(t);
                return count;
            } else {
                while (!queue.isEmpty() && t - poll > 3000) {
                    count--;
                    queue.pop();
                    poll = queue.peek();
                }
                queue.addLast(t);
                if (count <= 0) {
                    count = 1;
                    return 1;
                } else {
                    count++;
                    return count;
                }
            }
        }
    }
}
