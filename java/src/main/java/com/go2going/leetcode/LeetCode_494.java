package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_494 {
    public static void main(String[] args) {
        LeetCode_494 leetCode_494 = new LeetCode_494();
        System.out.println(leetCode_494.findTargetSumWays3(new int[]{1, 1, 1, 1, 1}, 3));
    }

    /**
     * 记忆化递归 72ms
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer,Integer>[] mem=new Map[nums.length];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = new HashMap<>();
        }
        return findTargetSumWays(nums, S, 0, mem);
    }

    private int findTargetSumWays(int[] nums, int S, int start,   Map<Integer,Integer>[] mem) {
        int ans = 0;

        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }
        if (mem[start].get(S)!=null) {
            return mem[start].get(S);
        }
        ans += findTargetSumWays(nums, S - nums[start], start + 1, mem);

        ans += findTargetSumWays(nums, S + nums[start], start + 1, mem);
        mem[start].put(S,ans);

        return ans;
    }

    /**
     * dp 这个题使用 dp有不同的状态转移方程
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int m = (nums == null) ? 0 : nums.length;
        if (m == 0) {
            if (S != 0) {
                return 0;
            } else {
                return 1;
            }
        }

        //int total = Arrays.stream(nums).sum();
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if ((S + total) % 2 != 0 || (S > total)) {
            return 0;
        }

        int target = (S + total) / 2;
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int num : nums) {
            for (int i = target; i >= num; --i) {
                dp[i] += dp[i - num];
            }
        }

        return dp[target];
    }


    /**
     * dp 我理解的思路 14ms
     * 参考的是这个图片的思路http://zxi.mytechroad.com/blog/wp-content/uploads/2018/01/494-ep156-3.png
     *
     * 图的思路还是很好理解的
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays3(int[] nums, int S) {
        int m = (nums == null) ? 0 : nums.length;
        if (m == 0) {
            if (S != 0) {
                return 0;
            } else {
                return 1;
            }
        }

        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (S > total) {
            return 0;
        }
        int[] dp = new int[2 * total + 1];
        //初始化位置
        dp[total] = 1;
        //前一个所有的可能值范围
        int tempSum = 0;
        for (int num : nums) {
            //这里为什么需要个临时数据，就是在下面for的时候会使得原先为0的index改变值，导致后面的出错
            int[] temp = new int[2 * total + 1];
            for (int i = -tempSum; i <= tempSum; i++) {
                int x = total + i;
                if (dp[x] != 0) {
                    temp[x + num] += dp[x] ;
                    temp[x - num] += dp[x] ;
                }
            }
            tempSum += num;
            dp = temp;
        }

        return dp[S+total];
    }
}
