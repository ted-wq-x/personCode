package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode_950 {
    /**
     * 有点绕人（实质就是一个模拟操作）
     * 可以换种理解方式，题目的意思是，有一个ans牌堆，按照题目的要去抓牌，其顺序从小到大
     * 但是我们不知道这个牌堆的顺序（即牌上数字），但是我们用一个空信封表示每张牌（信封上从0到length做上标记，表示牌的排列顺序）
     * 按照上面的方式进行抽取，那么就知道每个信封对于的值（数组index对于的值）
     * @param deck
     * @return
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int length = deck.length;
        //模拟desk，但是这里不是存的牌，而是index
        //因为我没不知道正确的排列方式，所以使用index表示
        //这里不能使用ArrayDeque，因为最后一次add是null
        LinkedList<Integer> q = new LinkedList<>();

        //形成牌堆
        for (int i = 0; i < length; i++) {
            q.add(i);
        }
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            //不知道index，但是知道选出来的值啊
            //ans[index]就是答案
            ans[q.poll()] = deck[i];
            q.add(q.poll());
        }
        return ans;
    }
}
