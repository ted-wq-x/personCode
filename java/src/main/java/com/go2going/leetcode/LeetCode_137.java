package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_137<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/25 0025 8:57
 */
public class LeetCode_137 {
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }


    public static void main(String[] args) {
        System.out.println(0^1&~0);
    }
}
