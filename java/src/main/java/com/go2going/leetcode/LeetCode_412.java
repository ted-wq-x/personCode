package com.go2going.leetcode;

import java.util.AbstractList;
import java.util.List;

/**
 * 理解了精髓，666
 * @author BlueT
 * 2017/10/21 20:12
 */
public class LeetCode_412 {

    private int size = 0;

    private final List<String> fizzbuzzList = new AbstractList<String>() {
        @Override
        public String get(int index) {
            final int i = index + 1;
            return i % 15 == 0 ? "FizzBuzz": i % 5 == 0 ? "Buzz": i % 3 == 0 ? "Fizz": String.valueOf(i);
        }

        @Override
        public int size() {
            return LeetCode_412.this.size;
        }
    };

    public List<String> fizzBuzz(int n){
        this.size = n;
        return fizzbuzzList;
    }
}
