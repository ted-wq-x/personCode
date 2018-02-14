package com.go2going.leetcode;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_179<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/14 0014 9:13
 */
public class LeetCode_179 {

    /**
     * 原本的思路是，比较每一位，取最大的值，但是121,12这样的组合不符合，所以我是错误的
     *
     * @param nums
     * @return
     */
    public String largestNumber1(int[] nums) {

        int length = nums.length;
        sort(nums, 0, length - 1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(nums[i]);
        }

        return sb.toString();
    }

    /**
     * 使用快排
     *
     * @param sum
     * @param start
     * @param end
     */
    private void sort(int[] sum, int start, int end) {
        int mid = sum[(start + end) / 2];

        int l = start, r = end;

        while (l <= r) {
            //从大到小
            while (sum[l] != mid && compare(sum[l], mid)) {
                l++;
            }

            while (sum[r] != mid && !compare(sum[r], mid)) {
                r--;
            }

            if (l <= r) {
                swap(sum, l++, r--);
            }
        }

        if (l < end) {
            sort(sum, l, end);
        }

        if (r > start) {
            sort(sum, start, r);
        }

    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private boolean compare(int a, int b) {
        String as = String.valueOf(a);
        String bs = String.valueOf(b);

        int i = as.length() - bs.length();
        if (i > 0) {
            b = b * (int) Math.pow(10, i);
        } else if (i < 0) {
            a = a * (int) Math.pow(10, -i);
        }

        if (a > b) {
            return true;
        } else if (a == b) {
            return Integer.parseInt(as) > Integer.parseInt(bs);
        } else {
            return false;
        }
    }


    /**
     * 参考https://leetcode.com/problems/largest-number/discuss/53158/My-Java-Solution-to-share
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        int length = nums.length;

        String[] str = new String[length];

        for (int i = 0; i < length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        //比较两个数，取大的
        Arrays.sort(str, (o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        });

        if (str[0].charAt(0) == '0') {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        LeetCode_179 leetCode_179 = new LeetCode_179();
        System.out.println(leetCode_179.largestNumber(new int[]{128, 12}));
    }
}
