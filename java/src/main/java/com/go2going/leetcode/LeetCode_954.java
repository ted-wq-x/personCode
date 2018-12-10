package com.go2going.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode_954 {

    /**
     * 968ms
     * @param A
     * @return
     */
    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);

        int length = A.length;
        int limit = length / 2;
        boolean[] cache=new boolean[length];
        for (int i = 0; i < limit; i++) {
            if (cache[i]) {
                continue;
            }
            int doubleV;
            if (A[i] < 0) {
                doubleV = A[i] / 2;
                if (A[i] % 2 != 0) {
                    return false;
                }
            } else {
                doubleV = A[i] * 2;
            }

            boolean find = false;
            for (int x = i+1; x < length; x++) {
                if (cache[x]) {
                    continue;
                }

                if (A[x] == doubleV) {
                    cache[x] = true;
                    find=true;
                    if (x < limit) {
                        limit++;
                        if (limit > length) {
                            limit=length;
                        }
                    }
                    break;
                } else if (A[x] > doubleV) {
                    return false;
                }

            }
            if (!find) {
                return false;
            }
            cache[i] = true;
        }

        return true;
    }

    /**
     * hen ok 68ms
     * @param A
     * @return
     */
    public boolean canReorderDoubled2(int[] A) {
        //sort
        Map<Integer, Integer> count = new TreeMap<>();
        for (int i : A) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        for (Integer integer : count.keySet()) {
            //这个数被用了，不需要找倍数了
            if (count.get(integer) == 0) {
                continue;
            }

            int target = integer < 0 ? integer / 2 : integer * 2;
            //小于0的奇数
            if (integer < 0 && integer % 2 != 0) {
                return false;
            }
            //数量不够
            if (count.get(integer) > count.getOrDefault(target, 0)) {
                return false;
            }
            count.put(target, count.get(target) - count.get(integer));
        }
        return true;
    }



    public static void main(String[] args) {
        LeetCode_954 leetCode_954=new LeetCode_954();

        // System.out.println(leetCode_954.canReorderDoubled(new int[]{3, 1, 3, 6}));
        // System.out.println(leetCode_954.canReorderDoubled(new int[]{2,1,2,6}));
        // System.out.println(leetCode_954.canReorderDoubled(new int[]{4,-2,2,-4}));
        // System.out.println(leetCode_954.canReorderDoubled(new int[]{1,2,4,16,8,4}));
        System.out.println(leetCode_954.canReorderDoubled2(new int[]{4,-4,4,-2,-4,-8}));
    }
}
