package com.go2going.leetcode;

import java.util.Arrays;

/**
 * @author BlueT
 * 2017/10/29 9:48
 */
public class LeetCode_621 {

    /**
     * https://www.youtube.com/watch?v=YCD_iYxyXoo
     * 关键还是理解最少次数的场景，以及特殊情况
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] ints = new int[26];
        for (char task : tasks) {
            ints[task - 'A']++;
        }

        Arrays.sort(ints);

        int maxQuery = ints[25];

        //计算和最大频率相同的task，比他小的之前的完成了
        int p = 0;
        for (int anInt : ints) {
            if (anInt == maxQuery) {
                p++;
            }
        }

        //（最大频率-1）*（间隔数+1）+和最大频率相同的task的个数
        //特殊情况，是没有空槽，那么就是tasks的长度
        return Math.max(tasks.length, (maxQuery - 1) * (n + 1) + p);

    }
}
