package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/2 21:03
 */
public class LeetCode_38 {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 2; i <= n; i++) {
            char[] chars = sb.toString().toCharArray();
            int index = 0;
            char pre = ' ';
            //清楚上一次的数据
            sb = new StringBuilder();
            for (int i1 = 0; i1 < chars.length; i1++) {
                char c = chars[i1];
                if (pre != c) {
                    //第一个数不用加
                    if (pre != ' ') {
                        sb.append(index).append(pre);
                    }
                    pre = c;
                    index = 1;
                }else {
                    index++;
                }

                //最后一个数得收尾
                if (i1 == chars.length - 1) {
                    sb.append(index).append(pre);
                }

            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode_38 leetCode_38 = new LeetCode_38();
        System.out.println(leetCode_38.countAndSay(5));
    }
}
