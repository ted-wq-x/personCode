package com.go2going.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_956 {
    public static void main(String[] args) {
        LeetCode_956 leetCode_956 = new LeetCode_956();
        System.out.println(leetCode_956.tallestBillboard(new int[]{1, 2, 3, 4, 5, 6}));
    }

    /**
     * 看似简单的问题，那是真的难
     * 181ms
     *
     * @param rods
     * @return
     */
    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);

        for (int rod : rods) {
            Map<Integer, Integer> cur = new HashMap<>(dp);
            for (Map.Entry<Integer, Integer> entry : cur.entrySet()) {
                Integer K = entry.getKey();
                dp.put(K + rod, Math.max(entry.getValue(), dp.getOrDefault(K + rod, 0)));
                int abs = Math.abs(K - rod);
                dp.put(abs, Math.max(dp.getOrDefault(abs, 0), entry.getValue() + Math.min(rod, K)));
            }
        }


        return dp.get(0);
    }


    /**
     * niubility 12ms  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-956-tallest-billboard/
     *
     * @param rods
     * @return
     */
    public int tallestBillboard2(int[] rods) {
        int s = 0;
        for (int rod : rods) {
            s += rod;
        }
        //两个高度差对于的最大长度
        int[] dp = new int[s + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int rod : rods) {
            int[] cur = Arrays.copyOf(dp, dp.length);
            for (int i = 0; i < dp.length; i++) {
                if (cur[i] == -1) {
                    continue;
                }
                //新加的棍子放在高的棍子上
                dp[i + rod] = Math.max(dp[i + rod], cur[i]);
                //新加的棍子放在矮的棍子上
                dp[Math.abs(i - rod)] = Math.max(dp[Math.abs(i - rod)], cur[i] + Math.min(rod, i));
            }

        }


        return dp[0];
    }

}
