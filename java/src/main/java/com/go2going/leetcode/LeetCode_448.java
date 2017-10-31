package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_448<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/31 0031 17:12
 */
public class LeetCode_448 {

    /**
     * 这题目mmp，高了好久，就为了不使用额外的空间
     * 思路是，将数据的每个位置和值进行对应，使用0,-1进行标记，0表示没有值，-1表示有值，使用临时缓存保存遍历时当前位置的值，需要注意特殊情况
     * 1.遍历完成时，缓存还有值
     * 2.
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();

        //临时缓存
        int index = 0;

        for (int i = 0; i < length||index!=0;) {

            //先判断缓存
            if (index != 0) {
                int num = nums[index - 1];
                //有值
                if ( num == -1) {
                    index = 0;
                    continue;
                }

                //不是0，则重置缓存
                if (num == 0) {
                    nums[index - 1] = -1;
                    index = 0;
                }else {
                    nums[index - 1] = -1;
                    index = num;
                }
                continue;
            }

            //减少循环
            if (i+1 == nums[i]) {
                nums[i ] = -1;
                i++;
                continue;
            }

            //正常的遍历
            if (nums[i] != 0) {
                //youzhi
                if (nums[i] != -1) {
                    index = nums[i];
                    nums[i] = 0;
                } else {
                    index = 0;
                }
            }
            i++;
        }

        //取值
        for (int i = 0; i < length; i++) {
            if (nums[i] ==0) {
                list.add(i + 1);
            }
        }

        return list;
    }

    /**
     * 这个性能最高但是，使用了额外的空间，没有完全达到题目的要求
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int[] test = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            test[nums[i]] = 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < test.length; i++) {
            if (test[i] == 0)
                ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] ints = new int[]{4,3,2,7,8,2,3,1};
        int[] ints = new int[]{4,3,2,7,7,2,3,1};
//        int[] ints = new int[]{1,1,2,4};
//        int[] ints = new int[]{1,2};
        LeetCode_448 leetCode_448 = new LeetCode_448();

        System.out.println(leetCode_448.findDisappearedNumbers(ints));

    }
}
