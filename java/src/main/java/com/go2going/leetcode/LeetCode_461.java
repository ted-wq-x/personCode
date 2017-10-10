package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_461<br>
 * 描述：汉明问题，https://leetcode.com/problems/hamming-distance/discuss/
 *
 * @author wangqiang
 * 创建时间：  2017/10/10 0010 18:43
 */
public class LeetCode_461 {

    /**
     * 思路：关键就是异或符号^,相同得0，不同的1，所以两个数直接异或后，算1的个数就行
     * @param a
     * @param b
     * @return
     */
    public int hanmingDistance(int a, int b) {
        return Integer.bitCount(a ^ b);
    }
}
