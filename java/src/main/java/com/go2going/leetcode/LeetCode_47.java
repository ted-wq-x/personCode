package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_47<br>
 * 描述：回溯算法
 *
 * @author wangqiang
 * 创建时间：  2017/12/29 0029 14:54
 */
public class LeetCode_47 {
    public static void main(String[] args) {
        LeetCode_47 leetCode_47 = new LeetCode_47();
        List<List<Integer>> lists = leetCode_47.permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }

    //标记元素是否使用过
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        used = new boolean[length];
        Arrays.sort(nums);
        backTrack(lists, new ArrayList<>(), nums, length);

        return lists;

    }

    /**
     * 使用的是回溯算法
     *
     * @return
     */
    public void backTrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int length) {
        //注意new
        if (list.size() == length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) continue;//去除重复使用元素，因为循环都是从0开始的，会出现用过的数再次使用的情况
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;//去除重复的值，前面的值没有用过，并且前面的值==当前值。这是重点
            list.add(nums[i]);
            used[i] = true;
            backTrack(lists, list, nums, length);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
