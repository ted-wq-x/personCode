package com.go2going.leetcode;


/**

 * 我都没有思考，直接看别人的答案，主要还是题目没明白
 *
 */
public class LeetCode_372 {
    private static final int M = 1337;

    /**
     * a^22=a^2*(a^10)^2
     *
     * @param a
     * @param b
     * @return
     */
    public int superPow(int a, int[] b) {
        a %= M;
        int ans = 1;

        int length = b.length;

        for (int i = length - 1; i >= 0; i--) {
            ans = ans * go(a, b[i]) % M;
            //将a-->a^10
            a = go(a, 10) % M;
        }


        return ans;
    }

    private int go(int a, int b) {

        int ans = 1;

        //通过这个方式能够有效的降低计算次数，相比于连续乘以b次a
        while (b != 0) {
            //奇数个加先乘上
            if (b % 2 != 0) {
                ans = ans * a % M;
            }
            //a 翻倍相当于a^20--->(a^2)^10
            a = a * a % M;
            // 如果b是奇数，由于上面在ans上补了一个，所以这儿直接/2是没有问题的
            b /= 2;
        }

        return ans;
    }
}
