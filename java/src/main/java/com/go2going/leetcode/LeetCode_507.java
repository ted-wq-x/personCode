package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_507<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/7 0007 14:11
 */
public class LeetCode_507 {
    /**
     * num=所有除num之外的正因素的和28 = 1 + 2 + 4 + 7 + 14
     *
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {

        if (num == 1) {
            return false;
        }
        int w = (int) Math.sqrt(num);
        int sum = 1;

        for (int i = 2; i <= w; i++) {
            int i1 = num % i;//判断是否整除
            if (i1 == 0 ) {
                sum = sum + i + num / i;
            }

        }
        return sum == num;
    }

    public static void main(String[] args) {
        LeetCode_507 leetCode_507 = new LeetCode_507();
        System.out.println(leetCode_507.checkPerfectNumber(28));
    }
}
