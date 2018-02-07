package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_769<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/7 0007 14:42
 */
public class LeetCode_769 {

    /**
     * https://www.youtube.com/watch?v=twYLu4hEKnQ
     * 学到的一点：当前个数=当前最大值，那么这段数组就可以排成连续的，也就是数据是完整的
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int num = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            //当前的最大值==个数，那么就认为从0到当前的index所有的数都是存在的，那么这个就是可以单独拆分的，对后面的数没有影响
            if (max == i ) {
                num++;
            }
        }
        return num;
    }
}
