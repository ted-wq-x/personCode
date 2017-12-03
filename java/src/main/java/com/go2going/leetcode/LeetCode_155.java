package com.go2going.leetcode;

import java.util.Stack;

/**
 * @author BlueT
 * 2017/12/3 16:16
 */
public class LeetCode_155 {
    class MinStack {

        Stack<Integer> stack;

        int min=Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {

            if (min >= x) {
                stack.push(min);//当push的数比当前的值小时，先push一个当前的值
                min = x;
            }

            stack.push(x);
        }

        public void pop() {
            if (stack.pop() == min) {
                min=stack.pop();//删除当前的最小值后，在pop就能获取当前的最小值，和push时的做法相呼应
            }

        }

        public int top() {
          return   stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
