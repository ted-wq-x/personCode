package com.go2going.leetcode;

import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_120<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/23 0023 8:58
 */
public class LeetCode_120 {

    /**
     * dp解，从下往上
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] A = new int[size + 1];
        for (int i = size - 1; i >= 0; --i) {
            //遍历每一行的元素
            for (int j = 0; j <= i; j++) {
                A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }

}
