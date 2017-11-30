package com.go2going.leetcode;

import java.util.Stack;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_232<br>
 * 描述：只需要实现push就行
 *
 * @author wangqiang
 * 创建时间：  2017/11/30 0030 10:40
 */
public class LeetCode_232 {
    class MyQueue {
        Stack<Integer> stack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            int size = stack.size();
            int[] s = new int[size];
            for (int i = 0; i < size; i++) {
                s[i] = stack.pop();
            }
            stack.push(x);
            for (int i = size - 1; i >= 0; i--) {
                stack.push(s[i]);
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {

            return stack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {

            return stack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}
