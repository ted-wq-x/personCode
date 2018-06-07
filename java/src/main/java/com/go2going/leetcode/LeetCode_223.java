package com.go2going.leetcode;

/**
 * medium
 */
public class LeetCode_223 {
    /**
     * 这题要get到，坐标的位置，如A,B永远是坐下角坐标，这样才能理解下面的return
     * @param A
     * @param B
     * @param C
     * @param D
     * @param E
     * @param F
     * @param G
     * @param H
     * @return
     */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int size = (C - A) * (D - B) + (G - E) * (H - F);

        //减去公摊

        if (H <= B || F >= D || E >= C || G <= A)
            return size;
        else
            //计算相交矩形的四个点坐标，然后计算面积
            return size - (Math.min(C, G) - Math.max(A,E)) * (Math.min(D,H) - Math.max(B, F));

    }
}
