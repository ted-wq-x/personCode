package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_201<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/14 0014 11:00
 */
public class LeetCode_201 {

    /**
     * 总而言之，这个问题是要求我们找到m和n的二进制代码的通用前缀。
     * https://www.youtube.com/watch?v=QJuQ5UxhYwE
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {

        int offset = 0;
        //只要m!=n那么m&n的最低位&必然是0（奇数偶数）
        while (m != n) {

            // 向右移动1位，相当于是删除最低位
            m >>= 1;
            n >>= 1;
            offset++;
        }

        // 此时相等就是进行删除之后的操作，如 01010和01011=》010，offset=2，所以结构就是010<<offset
        return m << offset;
    }
}
