package com.go2going.leetcode;

/**
 * hard
 */
public class LeetCode_878 {


    /**
     * 超时 O(N)，由于N <= 10^9，最直接的思维方式
     * @param N
     * @param A
     * @param B
     * @return
     */
    public static int nthMagicalNumber(int N, int A, int B) {
        int AI = 1, BI = 1;
        int p = 1000000007;
        while (N != 0) {
            long a1 = A * AI;
            long a2 = B * BI;
            if (a1 > a2) {
                BI++;
            } else if (a1 == a2) {
                BI++;
                AI++;
            } else {
                AI++;
            }
            N--;
        }
        AI--;
        BI--;
        long i = (long) AI * A;
        long j = (long) BI * B;
        return (int) Math.max(i % p, j % p);
    }


    /**
     * Let n denote the number of numbers <= X that are divisible by either A or B.
     *
     * n = X / A + X / B – X / lcm(A, B) = X / A + X / B – X / (A * B / gcd(A, B))
     *
     * Binary search for the smallest X such that n >= N
     *
     * lcm和gcd的转换关系 https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%85%AC%E5%9B%A0%E6%95%B8
     *
     * gcd:最大公约数
     * lcm:最小公倍数
     *
     *  Math + Binary Search
     *
     *  上面的公式我是想到的，只是有点乱，转换成最大公约数我是没想到，但是wiki上都有
     *
     * @param N
     * @param A
     * @param B
     * @return
     */
    public static int nthMagicalNumber1(int N, int A, int B) {

        long d = GCD(A, B);
        long l = 2;
        int p = 1000000007;
        long r = (long) (1e9 * 4e5);

        while (l < r) {
            long m = l + (r - l) / 2;
            if (m / A + m / B - m / (A * B / d) < N) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return (int) (l % p);
    }

    private static int GCD(int a, int b) {
        if(b==0) return a;
        return a % b == 0 ? b : GCD(b, a % b);
    }

    public static void main(String[] args) {

        System.out.println(1_00_23);
    }
}
