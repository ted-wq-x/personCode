package com.go2going.leetcode;

public class LeetCode_926 {
    public static void main(String[] args) {
        LeetCode_926 leetCode_926 = new LeetCode_926();
        System.out.println(leetCode_926.minFlipsMonoIncr("00110"));
    }

    /**
     * 从某一个位置开始前面的都是0，后面的都是1
     * 自己想的 12ms
     *
     * @param S
     * @return
     */
    public int minFlipsMonoIncr(String S) {
        char[] chars = S.toCharArray();
        //1 cache
        int length = chars.length;


        //记录1的个数
        int one = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i] == '1') {
                one++;
            }
        }

        //递增有两种情况，第一以1结尾的递增，第二都是0的递增
        //这里赋值是第二中情况需要的步骤
        int min = one;

        //缓存从第i位开始1的个数
        int[] cache = new int[length];

        for (int i = 0; i < length; i++) {
            if (chars[i] == '1') {
                cache[i] = one--;
            } else {
                cache[i] = one;
            }
        }

        for (int i = 0; i < length; i++) {
            //第i位后面需要变成1需要的次数
            int changeTo1 = length - i - cache[i];
            //第i位前面需要变成0需要的次数
            int changeTo0 = cache[0] - cache[i];
            int sum = changeTo0 + changeTo1;
            if (sum < min) {
                min = sum;
            }
        }

        return min;

    }
}
