package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_930 {
    public static void main(String[] args) {
        LeetCode_930 leetCode_930 = new LeetCode_930();
        System.out.println(leetCode_930.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
    }

    /**
     * medium
     *
     * sum[i:j]=prefix(j)-prefix(i-1)==target
     *
     * @param A
     * @param S
     * @return
     */
    public int numSubarraysWithSum(int[] A, int S) {

        Map<Integer, Integer> c = new HashMap<>();
        int sum = 0, ans = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            if (c.get(sum - S) != null) {
                ans += c.get(sum - S);
            }
            if (sum == S) {
                ans++;
            }
            c.put(sum,c.getOrDefault(sum,0)+1);
        }
        return ans;

    }

}
