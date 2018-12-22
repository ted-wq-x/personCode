package com.go2going.leetcode;

import java.util.Arrays;

public class LeetCode_556 {
    /**
     * 2ms
     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {
        String s = n + "";
        char[] chars = s.toCharArray();
        int length = s.length();
        //这题木就是从后向前找到一个位置使当前位置大于原来的数，然后当前位置后面的数排列成最小值
        int pre_index = -1, next_index = -1;
        for (int i = length-1; i >=0; i--) {
            for (int j = i-1; j>=0; j--) {
                if (chars[i] > chars[j]) {
                    if (j > pre_index) {
                        pre_index=j;
                        next_index = i;
                    }

                }
            }
        }
        //找到那个位置
        if (pre_index != -1) {
            return go(chars, length,next_index, pre_index);
        }
        return -1;

    }

    private int go(char[] chars, int length, int i, int j) {
        if (chars[j] == '0') {
            int c = nextGreaterElement(Integer.parseInt(new String(chars, j+1, length-j-1)));
            if (c != -1) {
                char[] chars1 = (c + "").toCharArray();
                for (int x = 0; x < chars1.length; x++) {
                    chars[j + 1 + x] = chars1[x];
                }
                return convert(chars);
            }
        }
        char aChar = chars[i];
        chars[i] = chars[j];
        chars[j] = aChar;
        //j后面的数组合成最小值
        Arrays.sort(chars, j+1, length);
        return convert(chars);
    }

    private int convert( char[] chars){
        int i1 = 0;
        try {
            i1 = Integer.parseInt(new String(chars));
        } catch (NumberFormatException e) {
            return -1;
        }
        return i1;
    }

    public static void main(String[] args) {
        LeetCode_556 leetCode_556=new LeetCode_556();
        System.out.println(leetCode_556.nextGreaterElement(230241)==230412);
        System.out.println(leetCode_556.nextGreaterElement(12443322)==13222344);

    }
}
