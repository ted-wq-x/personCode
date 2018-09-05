package com.go2going.leetcode;

import com.go2going.leetcode.huahua.SP1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author BlueT
 * 2018/8/15 22:34
 */
public class LeetCode_547 {
    public int findCircleNum(int[][] M) {
        SP1.UnionFindSet unionFindSet = new SP1.UnionFindSet(M.length);

        for (int i = 0; i < M.length; i++) {
            int[] ints = M[i];
            for (int j = 0; j < ints.length; j++) {

                if (ints[j] == 1) {
                    unionFindSet.union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < M.length; i++) {
            set.add(unionFindSet.find(i));
        }

        return set.size();
    }
}
