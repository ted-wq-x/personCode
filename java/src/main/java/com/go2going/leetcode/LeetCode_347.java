package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author BlueT
 * 2017/10/22 20:38
 */
public class LeetCode_347 {
    public List<Integer> topKFrequent1(int[] nums, int k) {

        //桶=》index=个数(频率),桶中的数据就是数字，频率的最大值就是长度+1
        List<Integer>[] all = new List[nums.length + 1];

        //key=数字，value=个数
        Map<Integer, Integer> map = new HashMap<>();

        //获取每个数字的频率
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Integer num : map.keySet()) {
            Integer integer = map.get(num);
            if (all[integer] == null) {
                all[integer] = new ArrayList<>();
                ;
            }
            all[integer].add(num);
        }
        List<Integer> res = new ArrayList<>();

        //all数组index就是每个数字的sum，到这取，那么个数最多的在前面，个数从大到小
        for (int i = all.length - 1; i >= 0 && res.size() < k; i--) {
            if (all[i] != null) {
                res.addAll(all[i]);
            }
        }
        return res;
    }

    /**
     * 有点是使用数组保存频率而不是hashMap，所以更快
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        //计算min和max是为了确定temp数组的长度，没有两个值没法创建数组
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //和上面的方法一样，index为频率，list为数字
        List<Integer>[] bucket = new List[nums.length + 1];

        //记录最大最小的数字
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        //临时的桶，最大长度就是max-min+1，index为数字（-min后的），值为频率
        int[] temp = new int[max - min + 1];

        //num-min为数字在临时桶中的位置
        //获取每个数字的频率
        for (int num : nums) {
            temp[num - min]++;
        }

        //下面两个for循环和上面类似

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                if (bucket[temp[i]] == null) bucket[temp[i]] = new ArrayList<>();
                //i+min还原数字
                bucket[temp[i]].add(i + min);
            }
        }


        for (int i = bucket.length - 1; i >= 0 && list.size() < k; i--) {
            if (bucket[i] != null) list.addAll(bucket[i]);
        }
        return list;
    }
}
