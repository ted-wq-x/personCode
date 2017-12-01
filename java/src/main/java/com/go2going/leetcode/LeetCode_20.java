package com.go2going.leetcode;

import java.util.Stack;

/**
 * @author BlueT
 * 2017/12/1 22:23
 */
public class LeetCode_20 {

    /**
     * [()]这个也是合法的
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (stack.empty()) {
                stack.push(aChar);
                continue;
            }
            if ( aChar == ')') {
                if (stack.pop() == '(') {
                    continue;
                } else {
                    return false;
                }
            } else if (aChar == ']') {
                if (stack.pop() == '[') {
                    continue;
                } else {
                    return false;
                }
            } else if ( aChar == '}') {
                if (stack.pop() == '{') {
                    continue;
                } else {
                    return false;
                }
            } else if(aChar=='('||aChar=='{'||aChar=='['){
                stack.push(aChar);
                continue;
            }
            return false;
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        LeetCode_20 leetCode_20 = new LeetCode_20();
        leetCode_20.isValid("()");
    }
}
