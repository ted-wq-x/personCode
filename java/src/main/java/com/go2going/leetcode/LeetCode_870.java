package com.go2going.leetcode;


import java.util.*;

public class LeetCode_870 {

    /**
     * Use the smallest unused number A[j] in A such that A[j] > B[i], if not possible, use the smallest number in A.
     * @param A
     * @param B
     * @return
     */
    public int[] advantageCount(int[] A, int[] B) {
        int length = A.length;
        int[] ans = new int[length];

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            Integer orDefault = map.getOrDefault(A[i], 0);
            map.put(A[i], ++orDefault);
        }

        for (int i = 0; i < length; i++) {
            Integer higher = ((TreeMap<Integer, Integer>) map).higherKey(B[i]);
            if (higher==null) {
                higher = ((TreeMap<Integer, Integer>) map).firstKey();
            }
            int integer = map.get(higher);
            if (--integer <= 0) {
                map.remove(higher);
            } else {
                map.put(higher, integer);
            }
            ans[i]= higher;
        }

        return ans;
    }

    public static void main(String[] args) {
        LeetCode_870 leetCode_870=new LeetCode_870();
        int[] ints = leetCode_870.advantageCount(new int[]{8,2,4,4,5,6,6,0,4,7}, new int[]{0,8,7,4,4,2,8,5,2,0});
        System.out.println(Arrays.toString(ints));
    }
}
