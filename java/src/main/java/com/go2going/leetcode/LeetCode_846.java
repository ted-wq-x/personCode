package com.go2going.leetcode;

import java.util.PriorityQueue;

public class LeetCode_846 {
    /**
     * 题意的理解不是很清晰：不要求分成的堆数也是W，就像打牌一样，用了一张牌之后，就从牌堆中去除了，每个牌堆是连续的
     * @param hand
     * @param W
     * @return
     */
    public boolean isNStraightHand(int[] hand, int W) {
        int length = hand.length;
        if (length % W != 0) {
            return false;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : hand){
            minHeap.add(i);
        }

        while (!minHeap.isEmpty()) {
            int start = minHeap.poll();
            //已经有一张start牌了
            for (int i = 1; i < W; i++) {
            //    要求是连续的,如果没有下一张牌false
                if (minHeap.remove(start + i)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
