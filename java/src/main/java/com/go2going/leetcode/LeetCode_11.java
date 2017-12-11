package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_11<br>
 * 描述：给定n个非负整数a1，a2，...，an，其中每个代表坐标（i，ai）处的一个点。 绘制n条垂直线，使得线i的两个端点处于（i，ai）和（i，0）处。 找到两条线，它们与x轴一起形成一个容器，使得容器包含最多的水。
 *
 * @author wangqiang
 * 创建时间：  2017/12/11 0011 10:26
 */
public class LeetCode_11 {


    /**
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int ll = height[l];
            int b = height[r];
            max = Math.max(max, Math.min(ll, b) * (r-l));

            //双向逼近
            if (ll < b) {
                l++;
            } else {
                r--;
            }
        }
        return max;

    }
}
