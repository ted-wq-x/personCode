package com.go2going.leetcode;

/**
 * 看不懂
 */
public class LeetCode_470 {
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     */
    public int rand10() {

        int index = Integer.MAX_VALUE;
        while (index >= 40)
            index = 7 * (rand7() - 1) + (rand7() - 1);
        return index % 10 + 1;
    }

    private int rand7(){
        return 1;
    }
}
