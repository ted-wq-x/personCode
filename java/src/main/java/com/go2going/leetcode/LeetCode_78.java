package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_78<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/16 0016 15:07
 */
public class LeetCode_78 {
    List<List<Integer>> returnList = new ArrayList<>();
    int length;

    /**
     * 求所有可能的子集合
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        length = nums.length;
        //统计的是数组的长度
        for (int i = 0; i <= length; i++) {
            get(new ArrayList<>(), 0, i, nums);
        }


        return returnList;
    }

    private void get(List<Integer> res, int index, int less, int[] nums) {
        //这个没多大提升，测试数据样本问题
      /*  if (index + less + 1 > length) {
            return;
        }
*/
        if (less == 0) {
            returnList.add(new ArrayList<>(res));
        }


        for (int i = index; i < length; i++) {
            res.add(nums[i]);
            get(res, i + 1, less - 1, nums);
            res.remove(res.size() - 1);
        }

    }
}
