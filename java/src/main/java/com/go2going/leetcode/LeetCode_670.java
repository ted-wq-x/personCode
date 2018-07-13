package com.go2going.leetcode;


/**
 * Medium
 */
public class LeetCode_670 {

    public static void main(String[] args) {
        LeetCode_670 leetCode_670 = new LeetCode_670();
        System.out.println(leetCode_670.maximumSwap(98386));
    }

    /**
     * 95% 哈哈，自己想的
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        char[] c = (""+num).toCharArray();

        int length = c.length;
        for (int i = 0; i < length; i++) {
            char pre = c[i];
            int maxIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (c[j] >= c[maxIndex]) {
                    maxIndex = j;
                }
            }
            // 此处的判断有点坑
            if (maxIndex != i && c[i] != c[maxIndex]) {
                char next = c[maxIndex];
                c[maxIndex] = pre;
                c[i] = next;
                return new Integer(new String(c));
            }

        }
        return num;

    }
}
