package com.go2going.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_386<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/23 0023 13:19
 */
public class LeetCode_386 {
    //找出数据的规律，一次性实现排序，很有难度，需要很大的精力规律
    public List<Integer> lexicalOrder(int n) {
        Integer[] res = new Integer[n];
        int cur = 1;
        for (int i = 0; i < n; i++) {
            res[i] = cur;
            if (cur * 10 <= n) {
                cur *= 10;//先把0的加上
            } else {
                //先判断，由于零头的存在
                if (cur >= n)
                    cur /= 10;//取整，如1000-》100-》10-》1
                cur += 1;
                while (cur % 10 == 0)//使用while，如199+1，那么下个数字应该是2
                    cur /= 10;
            }
        }
        return Arrays.asList(res);
    }
}
