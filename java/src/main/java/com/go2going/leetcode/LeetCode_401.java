package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_401<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/20 0020 9:02
 */
public class LeetCode_401 {

    public List<String> readBinaryWatch(int num) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    result.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return result;
    }

    public class Solution {

        //枚举出所有的组合
        String[][] hour = {{"0"},
                {"1", "2", "4", "8"},
                {"3", "5", "6", "9", "10"},
                {"7", "11"}};
        String[][] minute = {{"00"},
                {"01", "02", "04", "08", "16", "32"},
                {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},
                {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},
                {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},
                {"31", "47", "55", "59"}};

        public List<String> readBinaryWatch(int num) {
            List<String> ret = new ArrayList();
            for (int i = 0; i <= 3 && i <= num; i++) {
                if (num - i <= 5) {
                    for (String str1 : hour[i]) {
                        for (String str2 : minute[num - i]) {
                            ret.add(str1 + ":" + str2);
                        }
                    }
                }
            }
            return ret;
        }
    }
}
