package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/2 21:32
 */
public class LeetCode_69 {

    /**
     * 不能x
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;//会无限循环
        }
        int min = 1, max = x;

        while (true) {
            int mid = min + (max - min) / 2;
            int i = x / mid;
            //mid^2>x
            if (mid > i) {
                max = mid -1;
            } else if (mid == i) {//mid^2=x
                return mid;
            } else {
                //mid^2<x
                //(mid+1)^2>x
                //这边的计算次数较多
                if (x / (mid + 1) < mid+1) {
                    return mid;
                }

                min = mid + 1;
            }
        }


    }

    public int mySqrt3(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x;
        int ans = 0;//记录上一次的值
        while (left <= right) {
            int mid = left + (right - left)/2;

            if (mid > x/mid) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans ;
    }

    /**
     * 牛顿法
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        long r = x;

        while (r * r > x) {
            r = (x / r + r) / 2;
        }

        return (int) r;
    }
}
