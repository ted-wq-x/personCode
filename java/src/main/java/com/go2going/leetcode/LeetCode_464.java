package com.go2going.leetcode;

/**
 * 这题难度挺大的
 */
public class LeetCode_464 {
    /**
     * 0： initial
     * 1：win
     * -1：lose
     */
    private byte[] cache;

    /**
     * 题目已知条件maxChoosableInteger不超过20，所以内存占用不大
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // 求和
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }

        if (desiredTotal <= 0) {
            return true;
        }

        cache = new byte[1 << maxChoosableInteger];

        return canWin(maxChoosableInteger, desiredTotal, 0);
    }

    /**
     * @param maxChoosableInteger
     * @param desiredTotal
     * @param state               保存已经使用的数字，使用1byte表示用过的数
     * @return
     */
    private boolean canWin(int maxChoosableInteger, int desiredTotal, int state) {

        // 期望值<=0必然能赢
        if (desiredTotal <= 0) {
            return false;
        }

        // 判断当前使用的数，在缓存中是否有
        if (cache[state] != 0) {
            return cache[state] == 1;
        }
        for (int i = 0; i < maxChoosableInteger; i++) {
            // 判断当前的数是否被使用过
            if ((state & (1 << i)) > 0) {
                continue;
            }

            //如果对手没赢，那么我就能赢,i+1因为是从0开始的
            if (!canWin(maxChoosableInteger, desiredTotal - (i + 1), state | 1 << i)) {
                cache[state] = 1;
                return true;
            }
        }

        cache[state] = -1;

        return false;
    }
}
