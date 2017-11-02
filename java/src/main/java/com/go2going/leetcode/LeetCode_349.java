package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_349<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/2 0002 9:29
 */
public class LeetCode_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            int i1 = nums2[i];
            if (set.contains(i1)) {
                list.add(i1);
                //防止重复添加
                set.remove(i1);
            }
        }
        int size = list.size();
        int[] ints = new int[size];


        for (int i = 0; i < size; i++) {
            ints[i] = list.get(i);
        }

        return ints;
    }
}
