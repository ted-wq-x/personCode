package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_46<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/29 0029 14:23
 */
public class LeetCode_46 {


    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        backTrack(lists, new ArrayList<>(),  nums, length);

        return lists;

    }

    /**
     * 使用的是回溯算法
     *
     * @return
     */
    public void backTrack(List<List<Integer>> lists, List<Integer> list,  int[] nums,int length) {
        //注意new
        if (list.size() == length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < length; i++) {
            if(list.contains(nums[i])) continue;//去除重复元素
            list.add(nums[i]);
            backTrack(lists, list, nums,length);
            list.remove(list.size() - 1);
        }
    }
}
