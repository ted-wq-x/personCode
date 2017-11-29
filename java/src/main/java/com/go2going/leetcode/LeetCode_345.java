package com.go2going.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_345<br>
 * 描述：翻转元音字母，a,e,i,o,u
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 19:19
 */
public class LeetCode_345 {
    public String reverseVowels(String s) {
        char[] list=s.toCharArray();
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        for (int i = 0, j = list.length-1; i < j; ) {


            if (!set.contains(list[i])) {
                i++;
                continue;
            }

            if (!set.contains(list[j])) {
                j--;
                continue;
            }

            //运行到这i和j所处的位置就是元音字母

            char temp=list[i];
            list[i]=list[j];
            list[j]=temp;

            i++;
            j--;
        }

        return new String(list);
    }
}
