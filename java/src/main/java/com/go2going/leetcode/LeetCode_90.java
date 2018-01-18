package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_90<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/18 0018 9:38
 */
public class LeetCode_90 {
    List<List<Integer>> lists = new ArrayList<>();


    /**
     * 原先的思考方式是按照元素个数入手，但是这样无法解决重复的问题,78题可以使用这种 思路
     * 现在的思路是从包含的元素入手，如包含第一个元素的数组
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        get(new ArrayList<>(), nums, 0);

        return lists;
    }

    /**
     * @param list
     * @param nums
     * @param index 从第几个元素开始
     */
    private void get(List<Integer> list, int[] nums, int index) {
        if (index <= nums.length) {
            lists.add(new ArrayList<>(list));
        }

        for (int i = index; i < nums.length; i++) {

            //去重
            if (i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            get(list, nums, i + 1);
            list.remove(list.size() - 1);

        }

    }


    public static void main(String[] args) {
        LeetCode_90 leetCode_90 = new LeetCode_90();

        leetCode_90.subsetsWithDup(new int[]{1, 2, 3});
    }
}
