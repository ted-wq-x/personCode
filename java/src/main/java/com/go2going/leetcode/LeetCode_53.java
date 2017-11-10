package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_53<br>
 * 描述：dp算法科普<br>
 * <a href="https://zh.wikipedia.org/wiki/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92">wiki</a>
 *
 * @author wangqiang
 * 创建时间：  2017/11/8 0008 20:28
 */
public class LeetCode_53 {

    public int maxSubArray1(int[] nums) {

        int sum = nums[0];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int s = nums[i];
            if (s > sum) {
                sum = s;
            }
            for (int j = i + 1; j < length; j++) {
                s = s + nums[j];
                if (s > sum) {
                    sum = s;
                }
            }
        }

        return sum;
    }

    /**
     * dp算法，动态规划，关键在于分解成最小的问题
     *
     * 从上一个状态转移到下一个状态时，状态间要保持隔离
     * 很有挑战性
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int sum = nums[0];
        int length = nums.length;

        int[] dp = new int[length];//记录之前的累积值

        dp[0] = nums[0];//得把0补上

        for (int i = 1; i < length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);//设为0，就是不和前面的值相加
            sum = Math.max(sum, dp[i]);
        }

        return sum;
    }


    static Map<Integer, Integer> map = new HashMap<>();

    /**
     * wiki上动态规划的一个例子，使用map保存之前每步运算的值
     *
     * @param n
     * @return
     */
    public static int fp(int n) {
        if (map.get(n) == null) {
            if (n == 0 || n == 1) {
                map.put(n, n);
                return n;
            }
            int i = fp(n - 1) + fp(n - 2);
            map.put(n, i);
            return i;
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        long s = System.nanoTime();
        System.out.println(fp(35));
        long end = System.nanoTime() - s;
        System.out.println(end + " ms");
    }

}
