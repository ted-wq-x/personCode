package com.go2going.leetcode;

/**
 * 找规律的题目
 */
public class LeetCode_779 {
    public static void main(String[] args) {
        System.out.println((int) '0');
        LeetCode_779 leetCode_779 = new LeetCode_779();
        System.out.println(leetCode_779.kthGrammar(3, 3));
    }

    /**
     * 内存超了
     *
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar1(int N, int K) {
        int sumBit = (int) Math.pow(2, (N - 1));
        // 在前半部分
        int half = sumBit / 2;
        if (half >= K) {
            return kthGrammar1(N - 1, K);
        } else {
            // 在后半部分
            if (N == 1) {
                return 0;
            }
            String sb = "1";
            for (int i = 3; i <= N; i++) {
                StringBuilder sn = new StringBuilder();
                for (int i1 = 0; i1 < sb.length(); i1++) {
                    if (sb.charAt(i1) == '0') {
                        sn.append("01");
                    } else {
                        sn.append("10");
                    }
                }
                sb = sn.toString();
            }
            return sb.charAt(K - half - 1) - 48;
        }
    }

    /**
     * 找规律的题目
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (K % 2 == 0) return (kthGrammar(N - 1, K / 2) == 0) ? 1 : 0;
        else return (kthGrammar(N - 1, (K + 1) / 2) == 0) ? 0 : 1;
    }
}
