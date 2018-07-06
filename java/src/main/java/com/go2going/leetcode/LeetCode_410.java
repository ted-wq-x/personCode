package com.go2going.leetcode;

import java.util.Arrays;

/**
 * hard
 * 将数据分为m个子集，是的子集的和的最大值最小，注意是连续的，所以可以使用过dp的方式
 * https://leetcode.com/problems/split-array-largest-sum/description/
 */
public class LeetCode_410 {


    private int[] sum;

    private int[][] mem;

    public static void main(String[] args) {

        LeetCode_410 leetCode_410 = new LeetCode_410();
        System.out.println(leetCode_410.splitArray1(new int[]{1,2147483646}, 1));
    }

    /**
     * dp
     * time O(mnn)
     * space O(mn)
     * <p>
     * i=分组个数,k=index,0<=j<length
     * 状态转移方程：dp[i][j]=min{max(dp[i-1][k],sum(k+1,j))}
     *
     * @param nums size {1,1000}
     * @param m    size  {1,min(nums.size,50)}
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        //
        //存储以及求解的问题的解
        mem = new int[length][m + 1];
        for (int i = 0; i < length; i++) {
            //表示没有求解过
            Arrays.fill(mem[i], Integer.MAX_VALUE);
        }

        //缓存前n和
        sum = new int[length];
        sum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }

        return go(length - 1, m);
    }

    private int go(int k, int m) {
        if (m == 1) {
            return sum[k];
        }
        if (m > k + 1) {
            return Integer.MAX_VALUE;
        }
        if (mem[k][m] != Integer.MAX_VALUE) {
            return mem[k][m];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ans = Math.min(ans, Math.max(go(i, m - 1), sum[k] - sum[i]));
        }
        mem[k][m] = ans;
        return ans;
    }

    /**
     * binary search 最终的答案c在[max(nums],sum(nums))之间
     * 找到这个c，使得将nums划分为m组，每组的最大和不超过c
     * 那么从左往右累加和大于c，就重新累加，同时组数减1，当组数为0，还有数字没有分组的话，下界+1，否则上界=c
     * time O(log(sum(nums)*n)
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray1(int[] nums, int m) {
        int length = nums.length;

        //缓存前n和
        long l = nums[0];
        long h = nums[0];
        for (int i = 1; i < length; i++) {
            h += nums[i];
            if (nums[i] > l) {
                l = nums[i];
            }
        }


        while (l < h) {
            long mid = l + (h - l) / 2;
            if (minGroup(nums,  mid)>m) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        return (int) l;

    }

    /**
     * 计算每个组的和小于=c的组数
     * @return
     */
    private int minGroup(int[] nums, long c) {
        long sum = 0;
        int group = 1;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (sum + val > c) {
                sum = val;
                group++;
            } else {
                sum += val;
            }
        }
        return group;
    }
}
