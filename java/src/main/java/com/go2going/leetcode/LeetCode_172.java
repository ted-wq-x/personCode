package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_172<br>
 * 描述：求n!末尾0的个数
 *
 * @author wangqiang
 * 创建时间：  2017/11/30 0030 11:05
 */
public class LeetCode_172 {

    /**
     * 这个discuss的方法6666
     * 计算5的个数，有5必然有个前面的2，所以相乘有个0，但是当为25的时候有2个5，125有3个，也就是把大的数字拆分，如125=5*5*5
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        //再次递归的时候，由于除了5所以只会换后5*5的情况
        //如原先的10/5=2，再次递归就不会再算上，但是25/5=5就还会算上
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }


    /**
     * 和上面一样，非递归的方式
     * @param n
     * @return
     */
    public int trailingZeroes1(int n) {
        if (n <= 0) {
            return 0;
        }
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
