package com.go2going.leetcode;

import java.util.*;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_697<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/3 0003 9:58
 */
public class LeetCode_697 {

    /**
     * 90% 和别人的差距是我使用了list和map，而第一个使用的是数组
     * @param nums
     * @return
     */
    public static int findShortestSubArray(int[] nums) {
        int length = nums.length;

        //数字和出现的位置
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            List<Integer> integers = map.get(num);

            if (integers == null) {
                integers = new ArrayList<>();
                map.put(num, integers);
            }
            integers.add(i);
        }

        int max = 0;

        //计算出现次数最多的数
        List<Integer> sizeList = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            int size = integerListEntry.getValue().size();
            if (size > max) {
                sizeList.clear();
                max = size;
                sizeList.add(integerListEntry.getKey());
            } else if (size == max) {
                sizeList.add(integerListEntry.getKey());
            }
        }

        //找到距离最小的
        max=50000;
        for (Integer it : sizeList) {
            List<Integer> list = map.get(it);
            Integer min = list.get(0);
            Integer maxl = list.get(list.size() - 1);
            int maxTemp = maxl - min + 1;

            if (maxTemp < max) {
                max = maxTemp;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{1, 2, 2, 3, 1};

        System.out.println(LeetCode_697.findShortestSubArray(temp));
    }
}
