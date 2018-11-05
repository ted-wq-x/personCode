package com.go2going.leetcode;

public class LeetCode_935 {

    int P = 1_000_000_007;

    public static void main(String[] args) {
        LeetCode_935 leetCode_935 = new LeetCode_935();
        System.out.println(leetCode_935.knightDialer(1));
    }

    /**
     * 记忆化递归
     * @param N
     * @return
     */
    public int knightDialer(int N) {

        int[][] nums = new int[][]{{4, 6}, {8, 6}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[][] cache = new int[10][N];

        int count = 0;

        N--;
        for (int i = 0; i < 10; i++) {
            count += go(nums, i, N, cache);
            count %= P;
        }


        return count;
    }

    private int go(int[][] nums, int index, int N, int[][] cache) {

        if (N == 1) {
            return nums[index].length;
        } else if (N == 0) {
            return 1;
        }
        if (cache[index][N] != 0) {
            return cache[index][N];
        }
        long count = 0;

        int[] num = nums[index];
        for (int y = 0; y < num.length; y++) {
            int k = num[y];
            count += go(nums, k, N - 1, cache);
        }
        int i = (int) (count % P);
        cache[index][N] = i;
        return i;
    }
}
