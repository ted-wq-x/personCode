package com.go2going.leetcode;

import java.util.*;

/**
 * greedy,注意等级越高不代表钱越多
 * 参考:https://www.youtube.com/watch?v=hh1hF2hS3C4&t=41s
 * 但是视频中的方式,没有考虑到存在相同的difficulty,而profit不同的情况
 */
public class LeetCode_826 {
    /**
     * 48ms
     * time:nlogn
     * space:n
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        //1.排序worker
        Arrays.sort(worker);


        //2.difficulty排序
        int length = difficulty.length;
        Map<Integer, Integer> map = new HashMap<>(length);

        //注意此处会存在相同的key
        for (int i = 0; i < difficulty.length; i++) {
            int key = difficulty[i];
            if (map.get(key) == null) {
                map.put(key, profit[i]);
            } else {
                map.put(key, Math.max(profit[i],map.get(key)));
            }

        }

        //3.排序difficulty
        Arrays.sort(difficulty);

        //总利润
        int sum = 0;
        //记录当前的index,和当前index所取得的最大利润
        int curMaxProfit = 0, index = 0;
        //这个解法是默认等级越高profit越多
        /*for (int i = 0; i < worker.length; i++) {
            int level = worker[i];
            //最佳等级
            int val=0;
            while (index < length) {
                int value = difficulty[index];
                if (value == level) {
                    val = value;
                    break;
                } else if (value < level) {
                    if (index == length - 1) {
                        val = value;
                        break;
                    }
                    index++;
                } else {
                    //难度大于工人的最大值
                    if (index == 0) {
                        val =-1;
                    } else {
                        //取值前一个难度
                        val = difficulty[index - 1];
                    }
                    break;
                }
            }

            if (val != -1) {
                sum += map.get(val);
            }
        }*/

        for (int level : worker) {
            while (index < length && level >= difficulty[index]) {
                curMaxProfit = Math.max(curMaxProfit, map.get(difficulty[index++]));
            }
            sum += curMaxProfit;

        }
        return sum;
    }


    /**
     * 构造难度最大profit数组,25ms
     * work很多这种方式很有优势
     * time:n+m
     * space:m
     * @param difficulty
     * @param profit
     * @param worker
     * @return
     */
    public int maxProfitAssignment2(int[] difficulty, int[] profit, int[] worker) {

        final int size = 100000;

        int[] nums = new int[size+1];
        // Arrays.fill(nums, 0);

        for (int i = 0; i < difficulty.length; i++) {
            // 解决重复的difficulty
            if (nums[difficulty[i]] == 0) {
                nums[difficulty[i]] = profit[i];
            } else {
                nums[difficulty[i]] = Math.max(nums[difficulty[i]], profit[i]);
            }

        }

        //构造完整的等级最大利润表(在这个等级下,能够获得的最大profit)
        for (int i = 1; i < size; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1]);
        }

        int sum = 0;

        for (int i = 0; i < worker.length; i++) {
            sum+=nums[worker[i]];
        }
        return sum;
    }


    public static void main(String[] args) {
        LeetCode_826 leetCode_826 = new LeetCode_826();
        int i = leetCode_826.maxProfitAssignment(
                new int[]{66, 1, 28, 73, 53, 35, 45, 60, 100, 44, 59, 94, 27, 88, 7, 18, 83, 18, 72, 63},
                new int[]{66, 20, 84, 81, 56, 40, 37, 82, 53, 45, 43, 96, 67, 27, 12, 54, 98, 19, 47, 77},
                new int[]{61, 33, 68, 38, 63, 45, 1, 10, 53, 23, 66, 70, 14, 51, 94, 18, 28, 78, 100, 16}
                );

        System.out.println(i);

    }
}
