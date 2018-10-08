package com.go2going.leetcode;

/***
 * hard
 * dp
 * TODO 搞不定
 */
public class LeetCode_920 {
    private static final long MOD = (long) 1e9 + 7;

    /**
     * 全排列=n!/(n-l)!,当nl时=n!
     * F(N,L,K) = F(N - 1, L - 1, K) * N + F(N, L - 1, K) * (N - K)
     * @param N 总个数
     * @param L 列表的长度
     * @param K 两首相同的歌直接必须间隔k个歌
     * @return
     */
    public int numMusicPlaylists(int N, int L, int K) {
        long[][] dp = new long[N + 1][L + 1];
        for (int i = K + 1; i <= N; ++i)
            for (int j = i; j <= L; ++j)
                if ((i == j) || (i == K + 1))
                    dp[i][j] = factorial(i);
                else
                    dp[i][j] = (dp[i - 1][j - 1] * i + dp[i][j - 1] * (i - K)) % MOD;
        return (int) dp[N][L];
    }

    long factorial(int n) {
        return n > 0 ? factorial(n - 1) * n % MOD : 1;
    }
}
