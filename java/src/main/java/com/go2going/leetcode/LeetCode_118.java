package com.go2going.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_118<br>
 * 描述：如[9,8]===》表示数字98，题目的意思是+1
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 12:45
 */
public class LeetCode_118 {

    /**
     * 没啥难度，我自己使用的是list，但是提交后发现可以使用数组，确实没问题，因为大小是已经知道的
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        int[][] lists = new int[numRows][];
        int[] pre = null;

        for (int i = 0; i < numRows; i++) {
            int[] list = new int[i+1];
            list[0]=1;
            if (pre != null) {
                for (int i1 = 1; i1 <= i; i1++) {
                    int size = pre.length;
                    if (i1+1 <=size) {
                        list[i1]=pre[i1]+pre[i1-1];
                    } else{
                        list[i1] = 1;
                    }
                }
            }
            lists[i] = list;
            pre = list;
        }
        return (List)Arrays.asList(lists);
    }
}
