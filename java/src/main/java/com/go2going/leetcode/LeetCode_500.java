package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author BlueT
 * 2017/10/21 22:12
 */
public class LeetCode_500 {


    //最简单的遍历查找，效率最高
    String[] rows={"QWERTYUIOPqwertyuiop","ASDFGHJKLasdfghjkl","ZXCVBNMzxcvbnm"};
    public String[] findWords(String[] words) {

        ArrayList<String> result = new ArrayList<>();
        int currentRow;
        for (String word : words) {
            currentRow  = getCurrentRow(word.charAt(0));
            boolean isOk = true;
            //判断每个单词
            for (int i = 1; i < word.length(); i++) {
                if (rows[currentRow ].indexOf(word.charAt(i))==-1) {
                    isOk = false;//判断词是否满足条件
                    break;
                }

            }
            if (isOk) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public int getCurrentRow(char c) {
        for (int i = 0; i < 3; i++) {
            if (rows[i].indexOf(c) != -1) {
                return i;
            }

        }

        return -1;
    }


    public String[] findWords1(String[] words) {
      return   Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }


}
