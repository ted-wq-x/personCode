package com.go2going.leetcode;

import java.util.LinkedList;

public class LeetCode_754 {

    public static void main(String[] args) {
        LeetCode_754 leetCode_754 = new LeetCode_754();
        System.out.println(leetCode_754.reachNumber(3));
    }

    /**
     * Memory limit ERROR
     *
     * @param target
     * @return
     */
    public int reachNumber2(int target) {
        int count = 1;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (true) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == target) {
                    return count - 1;
                }
                queue.addLast(poll + count);
                queue.addLast(poll - count);
            }
            count++;
        }

    }

    /**
     * https://www.youtube.com/watch?v=Bdw2Y9FrqcU
     */
    public int reachNumber(int target) {
        int count = 0;
        if (target < 0) {
            target = -target;
        }

        int sum = 0;
        while (sum < target) {
            sum += ++count;
        }

        int d = target - sum;
        if (d % 2 == 0) {
            return count;
        }
        return count + 1 + (count % 2);

    }
}
