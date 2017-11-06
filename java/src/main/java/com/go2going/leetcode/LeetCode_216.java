package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_216<br>
 * 描述：不会，但是理解了
 *
 * @author wangqiang
 * 创建时间：  2017/11/6 0006 11:14
 */
public class LeetCode_216 {
    List<List<Integer>> listList = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        com(k, 1, n, new ArrayList<>());
        return listList;
    }

    public void com(int count, int start, int sum, List<Integer> list) {

        if (count == 0) {
            if (sum == 0) {
                //符合条件的添加，注意需要新建list，因为原有的list中的数据一直再被操控
                List<Integer> l = new ArrayList<>(list);
                listList.add(l);
            }

            //次数用完，不符合条件的也结束递归
            return;
        }

        for (int i = start; i <= 9; i++) {
            list.add(i);

            //次数减一，下次递归的开始值加一（数字不能重复），期望值-i
            com(count - 1, i + 1, sum - i, list);

            //如1,2,6符合，到这里删除6，继续循环
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        LeetCode_216 leetCode_216 = new LeetCode_216();
        List<List<Integer>> lists = leetCode_216.combinationSum3(3, 9);
        System.out.println(lists.size());
    }

}
