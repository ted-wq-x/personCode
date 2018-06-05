package com.go2going.leetcode;

public class LeetCode_334 {

    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }

        //保留最小的和第二小的
        int min1 = nums[0], min2 = 0;

        //第一次比较min2的时候，是不比较的，而是赋值，所以上面min2=0，这个值随意，如果用MAX就不需要用go了
        boolean go = false;

        //原理：
        //min2的作用有两个：1.正常情况下，先找到最小的给min1，再找到第二小的给min2，只要再找个>min2返回true
        //2. 当go=true之后，发现有一个比min1小的，此时的min2相当于保留之前的最小值，如果此时找到一个>min2则返回true
        //当min2也被更改了之后，类似于4，5,1,2,6，这种情况后面的连续1,2，肯定比前面的连续4,5小，所以后面的只要比2大就ok

        for (int i = 1; i < length; i++) {
            if (nums[i] > min1) {
                //因为已经有两值了，所以只要再找到一个就行
                if (go && nums[i] > min2) {
                    return true;
                } else {
                    min2 = nums[i];
                    go = true;
                }
            } else {
                min1 = nums[i];
            }
        }
        return false;
    }

    public boolean increasingTriplet1(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }

        int min1 = nums[0], min2 = Integer.MAX_VALUE;

        for (int i = 1; i < length; i++) {
            if (nums[i] > min1) {
                if (nums[i] > min2) {
                    return true;
                } else {
                    min2 = nums[i];
                }
            } else {
                min1 = nums[i];
            }
        }
        return false;
    }
}
