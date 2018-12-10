package com.go2going.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_953 {

    /**
     * easy 但是对我并不easy 16ms
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        int length = words.length;
        if (length == 1) {
            return true;
        }
        String[] newA = new String[length];
        System.arraycopy(words,0,newA,0,length);

        int[] cache = new int[26];
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int i1 = chars[i] - 'a';
            cache[i1] = i;
        }

        Arrays.sort(words, new Comparator<String>() {
            //参考jdk字符串比较源码
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                int lim = Math.min(len1, len2);
                char v1[] = o1.toCharArray();
                char v2[] = o2.toCharArray();

                int k = 0;
                while (k < lim) {
                    char c1 = v1[k];
                    char c2 = v2[k];
                    if (c1 != c2) {
                        return cache[c1-'a' ]- cache[c2-'a'];
                    }
                    k++;
                }
                return len1 - len2;
            }
        });

        for (int i = 0; i < length; i++) {
            if (!newA[i].equals(words[i])) {
                return false;
            }
        }
        return true;
    }


    /**
     * 5ms，在上面基础上的改进
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted2(String[] words, String order) {
        int length = words.length;
        if (length == 1) {
            return true;
        }

        int[] cache = new int[26];
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int i1 = chars[i] - 'a';
            cache[i1] = i;
        }

        char[] before = words[0].toCharArray();
        for (int i = 1; i < length; i++) {
            char[] cur = words[i].toCharArray();
            int len1 = before.length;
            int len2 = cur.length;
            int lim = Math.min(len1, len2);
            int k = 0;
            while (k < lim) {
                char c1 = before[k];
                char c2 = cur[k];
                if (c1 != c2) {
                    //before>cur
                    if (cache[c1 - 'a'] > cache[c2 - 'a']) {
                        return false;
                    } else {
                        break;
                    }
                }
                k++;
            }
            if (k == lim&& len1 > len2) {
                return false;
            }
            before=cur;
        }

        return true;
    }

    public static void main(String[] args) {
        LeetCode_953 leetCode_953=new LeetCode_953();
        System.out.println(leetCode_953.isAlienSorted2(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));//true
        System.out.println(leetCode_953.isAlienSorted2(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));//false
        System.out.println(leetCode_953.isAlienSorted2(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));//false
    }
}
