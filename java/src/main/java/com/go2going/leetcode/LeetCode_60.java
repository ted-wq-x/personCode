package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_60<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/10 0010 20:42
 */
public class LeetCode_60 {
    /**
     * 全排列
     * n的阶乘个数，从小到大，去第k个，从1开始数的
     *
     * @param n
     * @param k 第几个数
     * @return
     */
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();//存放还没使用的数字
        int[] factorial = new int[n + 1];//阶乘
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
            numbers.add(i);
        }

        k--;

        // 1,2,3,4
        //
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];//计算索引的位置
            sb.append(numbers.remove(index));
            k -= index * factorial[n - i];//重新计算k值，当前索引的个数*剩余需要的个数的阶乘
        }

        return String.valueOf(sb);
    }
}
