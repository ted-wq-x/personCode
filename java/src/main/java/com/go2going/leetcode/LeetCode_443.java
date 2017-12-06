package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_443<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/6 0006 14:00
 */
public class LeetCode_443 {

    public static void main(String[] args) {
        LeetCode_443 leetCode_443 = new LeetCode_443();
        System.out.println(leetCode_443.compress(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'g', 'g', 'g', 'g',
                'g', 'g', 'g', 'g', 'g', 'g', 'g', 'a',
                'b', 'c'}));

    }

    /**
     * 原地压缩
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int length = chars.length;

        if (length == 0) {
            return 0;
        }

        //sum记录当前字母的个数，firstCharIndex原地插入修改的位置
        int sum = 1,firstCharIndex=0;
        char pre = chars[0];
        for (int i = 1; i < length; i++) {
            if (chars[i] == pre) {
                sum++;
            } else {
                //不相等
                chars[firstCharIndex++]= pre;
                if (sum != 1) {
                    //设置个数，这个不会越界
                    char[] chars1 = Integer.toString(sum).toCharArray();
                    if (sum <= 9) {
                        chars[firstCharIndex++] = chars1[0];
                    } else {
                        int length1 = chars1.length;
                        for (int j = 0; j < length1; j++) {
                            chars[firstCharIndex++] = chars1[j];
                        }
                    }
                }

                sum = 1;
                pre = chars[i];
            }
        }

        chars[firstCharIndex++]= pre;
        if (sum != 1) {
            char[] chars1 = Integer.toString(sum).toCharArray();
            if (sum <= 9) {
                chars[firstCharIndex++] = chars1[0];
            } else {
                int length1 = chars1.length;
                for (int j = 0; j < length1; j++) {
                    chars[firstCharIndex++] = chars1[j];
                }
            }
        }

        return firstCharIndex;

    }
}
