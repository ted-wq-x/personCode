package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/10 20:56
 */
public class LeetCode_6 {
    /**
     * 将字符串转换成指定的长度，符合z的样式,49ms
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;

        StringBuilder[] sb = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int index = 0;
        boolean isPlus = true;
        for (int i = 0; i < length; i++) {
            sb[index].append(chars[i]);
            if (isPlus && index == numRows - 1) {
                isPlus = false;
            } else if (!isPlus && index == 0) {
                isPlus = true;
            }
            if (isPlus) {
                index++;
            } else {
                index--;
            }
        }
        StringBuilder stringBuilder = sb[0];

        for (int i = 1; i < numRows; i++) {
            stringBuilder.append(sb[i]);
        }

        return stringBuilder.toString();
    }
}
