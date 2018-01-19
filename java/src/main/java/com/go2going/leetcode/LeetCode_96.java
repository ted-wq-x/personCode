package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_96<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/19 0019 15:50
 */
public class LeetCode_96 {
    /**
     * 规律总结，不会
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }

        return G[n];
    }

}
