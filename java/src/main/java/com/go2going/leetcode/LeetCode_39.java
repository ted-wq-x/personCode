package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_39<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/27 0027 15:32
 */
public class LeetCode_39 {

    List<List<Integer>> re = new ArrayList<>();

    /**
     * 特体很值得学习
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int length = candidates.length;
        if (length != 0) {
            Arrays.sort(candidates);
            get(new ArrayList<>(), target, 0, candidates,length);
        }

        return re;
    }


    /**
     * 递归加循环遍历，注定很慢
     * @param list
     * @param target
     * @param start
     * @param num
     */
    private  void get(List<Integer> list, int target, int start, int[] num,int length) {
        if (target == 0) {
            //在这创建新的，原有的继续使用
            re.add(new ArrayList<>(list));
        } else if (target > 0) {
            //
            for (int i = start; i < length; i++) {
                list.add(num[i]);
                int target1 = target - num[i];
                //这个判断提高了很多的性能
                if (target1 >= 0) {
                    get(list, target1, i, num,length);
                }
                list.remove(list.size() - 1);
            }
        }
    }

}