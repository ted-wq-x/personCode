package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_371<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/1 0001 10:21
 */
public class LeetCode_371 {
    public  int getSum(int a, int b) {

        if(b==0) return a;
        int sum = a ^ b;//按位加
        int car = (a & b) << 1;//获取进位
        return  getSum(sum, car);//递归消除所有的进位
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_371().getSum(20,33));
    }
}
