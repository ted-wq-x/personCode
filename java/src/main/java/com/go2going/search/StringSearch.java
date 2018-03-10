package com.go2going.search;

import org.junit.Assert;

import java.util.Arrays;

/**
 * @author BlueT
 * 2018/3/8 23:33
 */
public class StringSearch {

    public static void main(String[] args) {
        BoyerMoore boyerMoore = new BoyerMoore("adc");
        Assert.assertEquals(4,boyerMoore.search("hgcdadc"));
    }

    /**
     * 暴力查找非常简单，但是很低效，因为遍历过的字符依然要查找一边
     * @param text 带查找字符串
     * @param target 目标字符串
     * @return index
     */
    private static int BFSearch(String text, String target) {
        int l1 = text.length();
        int l2 = target.length();
        for (int i = 0; i < l1; i++) {
            int j;
            for (j= i; j < l2; j++) {
                if (target.charAt(j) != text.charAt(i)) {
                    break;
                }
            }
            if (j == l2) {
                return i;
            }
        }
        return -1;
    }


    /**
     * BM算法，大多数文本编辑器查找采用的算法
     * 查找时存在三种情况
     * 1. 匹配失败的字符不包含在模式字符串中：j+1(也就是 j-(-1))
     * 2. 存在于模式字符串中：j-ints[index]
     * 3. 如果skip<=0，就让skip=1，也就是外循环必须前进一次
     */
   static class BoyerMoore {

        /**
         * 需要查找的字符串
         */
        private String text;
        /**
         * 跳跃表
         */
        private int[] ints ;//字母最右边的位置

        public BoyerMoore(String text) {
            this.text = text;
            ints = new int[256];
            Arrays.fill(ints, -1);

            for (int i = 0; i < text.length(); i++) {
                // 字符出现最右边的位置
                ints[text.charAt(i)]=i;
            }
        }

        /**
         * 比如 string=adbcedghg
         *     text=abc
         *
         * @param string  被查找的字符串
         * @return
         */
        public int search(String string) {
            int sl = string.length();
            int tl = text.length();
            int skip;
            // string
            for (int i = 0; i <= sl - tl; i+=skip) {
                skip = 0;

                // text
                for (int j = tl-1; j >=0; j--) {

                    if (string.charAt(j+i) != text.charAt(j)) {
                        // 为什么是j-跳跃数？画图理解
                        skip = j - ints[string.charAt(i+j)];
                        // 至少移动一位
                        if (skip <= 0) {
                            skip = 1;
                        }
                        break;
                    }
                }
                // 所有字符都匹配，那么就不会进入内循环的if
                if (skip == 0) {
                    return i;
                }
            }

            return -1;
        }
    }
}


