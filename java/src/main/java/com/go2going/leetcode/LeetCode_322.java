package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 我的做法都是dfs，这题还有dp的方式，参考 https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-322-coin-change/
 */
public class LeetCode_322 {

    public static void main(String[] args) {
        LeetCode_322 leetCode_322 = new LeetCode_322();

        System.out.println(leetCode_322.coinChange2(new int[]{1, 2, 5}, 100));
    }

    /**
     * 这种方式，上不上sort，从测试来看影响不大
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] cache = new int[amount];
        Arrays.sort(coins);
        return go(amount, cache, coins);

    }

    /**
     * 137ms---41ms---38ms
     *
     * @param amount
     * @param cache
     * @param coins
     * @return
     */
    private int go(int amount, int[] cache, int[] coins) {

        int sum = Integer.MAX_VALUE;
        for (int coin : coins) {
            int remaining = amount - coin;
            if (remaining < 0) {
                break;
            } else if (remaining == 0) {
                return 1;
            }
            int integer = cache[remaining];
            if (integer == 0) {
                integer = go(remaining, cache, coins);
            }
            if (integer != -1 && integer < sum) {
                sum = integer;
            }
            cache[remaining] = integer;
        }

        if (sum == Integer.MAX_VALUE) {
            return -1;
        } else {
            return sum + 1;
        }
    }

    /**
     * 110ms-->36ms
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.sort(coins);
        int length = coins.length;
        int index = 0;
        queue.add(amount);
        int[] cache = new int[amount];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer pop = queue.pop();
                for (int y = 0;  y < length; y++) {
                    int remaining = pop - coins[y];
                    if (remaining == 0) {
                        return index + 1;
                    } else if (remaining < 0) {
                        break;
                    } else {
                        if (cache[remaining] == 0) {
                            queue.add(remaining);
                            cache[remaining] = 1;
                        }
                    }
                }
            }
            index++;
        }
        return -1;
    }


    /**
     * dp 13ms 总觉得有点很难理解
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        //表示累积到index的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int coin : coins) {
            // i=coin表示上一次外循环产生的所有数，进行遍历
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }



    int ans = Integer.MAX_VALUE;

    /**
     * DFS+greedy+pruning(剪枝) 10ms 很棒的想法
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange4(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);


        //从最大的硬币开始（greedy）
        coinChange(coins, amount,0,coins.length-1);
        if (ans == Integer.MAX_VALUE) {
            return -1;

        } else {
            return ans;
        }
    }


    /**
     *
     * @param coins
     * @param amount 剩余的钱
     * @param count 使用的硬币数
     * @param index 使用硬币的index，之前的都不用了
     */
    private void coinChange(int[] coins, int amount, int count,int index) {

        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        if (index < 0) {
            return;
        }

        int coin = coins[index];
        //剪枝 i + count < ans
        //第一次尝试使用最多的最大值硬币
        for (int i = amount / coin; i >= 0 && i + count < ans; i--) {
            //使用i个index的硬币
            coinChange(coins, amount - coin * i, count + i, index - 1);
        }

    }
}
