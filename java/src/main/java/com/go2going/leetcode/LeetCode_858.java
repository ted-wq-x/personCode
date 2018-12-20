package com.go2going.leetcode;

public class LeetCode_858 {
    /**
     * 很有意思的题目，虽然我不会，看了discuss之后
     * 当光线到达接收器时，在水平方向走的距离为mp,垂直方向走的是nq，找出最小公倍数，得到次数，根据次数画图找规律
     * @param p
     * @param q
     * @return
     */
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p /= 2;
            q /= 2;
        }
        if (p % 2 == 0) {
            return 2;
        } else if (q % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        LeetCode_858 leetCode_858=new LeetCode_858();

        System.out.println(leetCode_858.mirrorReflection(5, 1));
    }

}
