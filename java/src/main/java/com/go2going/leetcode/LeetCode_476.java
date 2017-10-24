package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_476<br>
 * 描述：基础知识，源码，反码，补码，数字在计算机中是以补码的方式存储
 * 问题在于最高位前面的0，屏蔽掉
 * @author wangqiang
 * 创建时间：  2017/10/24 0024 10:36
 */
public class LeetCode_476 {
    public int findComplement1(int num) {
        int mask = ~0;
        while ((num & mask)!=0) mask <<= 1;
        return ~mask & ~num;
    }

    /**
     * 由于最高位的1肯定会变为0的，所以就不需要管了
     * @param num
     * @return
     */
    public int findComplement(int num) {
        //保留最高为1,后面的计算结果为0...1111(比如)，当和前面的数字按位与时，只有都为1结果才为1，所以就屏蔽掉了前面的数
        return ~num & (Integer.highestOneBit(num) - 1);
    }

    public static void main(String[] args) {
        System.out.println(~5);//-6
        System.out.println(~0);//-1
        System.out.println(~11);//-12，计算过程，所有位取反，最高位为符号位-》1。。。
        System.out.println(~(-5));//4
    }


}
