package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_204<br>
 * 描述：计算小于n的素数的个数
 *
 * @author wangqiang
 * 创建时间：  2017/12/4 0004 10:14
 */
public class LeetCode_204 {

    /**
     * 非常牛逼的姿势
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];//默认都是素数
        int count = 0;
        //2是素数
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2; i*j < n; j++) {//i*j=k说明会k不是素数
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}
