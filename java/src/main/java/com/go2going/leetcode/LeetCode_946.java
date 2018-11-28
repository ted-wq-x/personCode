package com.go2going.leetcode;

import java.util.Stack;

public class LeetCode_946 {
    /**
     * 这个想法很好
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        //i就是pop数组的位置
        int i = 0;
        for (int x : pushed) {
            s.push(x);
            //模拟pop的操作，由于题目提示没有重复的数，所以可以判断栈顶元素是否等于pop的元素
            while (!s.empty() && s.peek() == popped[i]) {
                s.pop();
                i++;
            }
        }
        //判断pop是不是到最后了
        return i == popped.length;
    }
}
