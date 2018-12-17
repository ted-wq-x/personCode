package com.go2going.leetcode;

public class LeetCode_957 {
    /**
     * 很显然是找规律的题
     * @param cells
     * @param N
     * @return
     */
    public int[] prisonAfterNDays(int[] cells, int N) {
        //在n=14，时N=N%14为0，错了，所以要把这个错误修补上
        for (N = (N-1)  % 14 +1; N > 0; --N) {
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
        }
        return cells;
    }
}
