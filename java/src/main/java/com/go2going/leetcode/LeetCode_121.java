package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_121<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/16 0016 18:43
 */
public class LeetCode_121 {

    //Kadane算法时间复杂度为 {\displaystyle {\mathcal {O}}(n)} \mathcal{O}(n)，空间复杂度为 {\displaystyle {\mathcal {O}}(1)} \mathcal{O}(1)
    //只需要一次循环
    public int maxProfit1(int[] prices) {

        //定义后一个元素和前面元素的差值，》=0，小于0是没有意义的
        int gap = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            //
            gap = Math.max(0, gap + (prices[i] - prices[i - 1]));
            max = Math.max(max, gap );

        }
        return max;
    }


    //找最小值和最大值，最小值在左边，最大值的确定，使用的是和最小值的距离
    public int maxProfit(int[] prices) {

        //保存最小值
        int min = Integer.MAX_VALUE;

        int max = 0;

        for (int price : prices) {
            //找出最小值
            if (price < min) {
                min = price;
            } else if (price - min > max) {
                max = price - min;
            }
        }
        return max;
    }


    //下面的算法性能最

}
