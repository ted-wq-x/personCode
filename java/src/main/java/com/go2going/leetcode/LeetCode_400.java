package com.go2going.leetcode;

public class LeetCode_400 {
    /**
     * 统计数字的长度
     *
     * @param t
     * @return
     */
    private static int countNumLength(int t) {
        int count = 0;
        while (true) {
            count++;

            if (t < 10) {
                break;
            }
            t /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        LeetCode_400 leetCode_400=new LeetCode_400();
        // System.out.println(leetCode_400.findNthDigit(29)==9);
        System.out.println(leetCode_400.findNthDigit(30)==2);
        // System.out.println(leetCode_400.findNthDigit(15)==2);
    }

    /**
     * 太恶心了
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));

    }
}
