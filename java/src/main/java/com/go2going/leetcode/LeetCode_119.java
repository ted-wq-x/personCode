package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_119<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/30 0030 10:15
 */
public class LeetCode_119 {
    public List<Integer> getRow(int rowIndex) {
        int[] pre=null;

        for (int i = 0; i <=rowIndex; i++) {
            int[] cur = new int[i + 1];
            cur[0] = 1;
            cur[i] = 1;
            if (pre != null) {
                //第一个和最后一个不用设置
                for (int j = 1; j < i ; j++) {
                    cur[j] = pre[j - 1 <= 0 ? 0 : j - 1] + pre[j];
                }
            }
            pre = cur;
        }

        List<Integer> list = new ArrayList<>();
        for (int i : pre) {
            list.add(i);
        }

        return list;
    }

    public static void main(String[] args) {
        LeetCode_119 leetCode_119 = new LeetCode_119();
        List<Integer> row = leetCode_119.getRow(3);
        System.out.println(row);
    }
}
