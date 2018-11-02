package com.go2going.leetcode;

public class LeetCode_907 {

    private static final int P = 1000000007;

    public static void main(String[] args) {

        LeetCode_907 leetCode_907 = new LeetCode_907();
        System.out.println(leetCode_907.sumSubarrayMins(new int[]{48,87,27}));
    }

    /**
     * 96/100 passed 超时
     *
     * @param A
     * @return
     */
    public int sumSubarrayMins(int[] A) {
        return go(A, 0);
    }

    private int go(int[] A, int start) {


        int length = A.length;
        int min = A[start];
        int sum = min;
        for (int y = start + 1; y < length; y++) {
            if (A[y] < min) {
                min = A[y];
            }
            sum += min;
        }

        if (start + 1 < length) {
            sum += go(A, start + 1);
        }

        return sum % P;

    }

    /**
     * 567ms https://zxi.mytechroad.com/blog/stack/leetcode-907-sum-of-subarray-minimums/
     * @param A
     * @return
     */
    public int sumSubarrayMins4(int[] A) {
        int mod = 1000000007;
        int length = A.length;
        int ans = 0;

        for (int i = 0; i < length; i++) {
            int left = 0;
            for (int j = i - 1; j >= 0 && A[j] > A[i]; j--, left++);

            int right = 0;
            for (int j = i + 1; j < length && A[j] >= A[i]; j++, right++) ;

            ans = (int)((ans + (long)A[i] * (left + 1) * (right + 1)) % mod);
        }
        return ans;
    }



    public int sumSubarrayMins3(int[] A) {
        if (A == null || A.length == 0) return 0;
        int MOD = 1_000_000_007;
        int cur = 0, total = 0, len = A.length, top = 0;
        //Stack<Integer> stk = new Stack<>();
        int[] stk = new int[len];
        int [] cnts = new int[len];
        for (int i = 0; i < A.length; ++i) {
            int idx = i;
            while (top > 0 && A[i] <= A[stk[top - 1]]) {
                idx = stk[--top];
                cur -= cnts[idx] * A[idx];
            }
            cnts[i] = (top == 0 ? i + 1 : i - stk[top - 1]);
            stk[top++] = i;
            cur += cnts[i] * A[i];
            total = (total + cur) % MOD;
        }
        return total;
    }


}
