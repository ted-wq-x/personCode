package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_541<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/16 0016 11:20
 */
public class LeetCode_541 {
    /**
     * 题目的意思是每2k个元素中前k个反转
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ) {

            int end = i+ 2 * k;

            if (end >= length) {
                end = length;
            }
            int sum = i + k;
            if (sum >= length) {
                sum = length;
            }
            String substring = s.substring(i, sum);
            String sr = s.substring(sum, end);
            StringBuilder append = new StringBuilder(substring).reverse().append(sr);
            sb.append(append);
            i = end;
        }

        return sb.toString();
    }
}
