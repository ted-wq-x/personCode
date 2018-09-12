package com.go2going.util;

public final class StringUtils {
    private StringUtils(){}

    /**
     * 字符串翻转
     * @param str
     * @return
     */
    public static String reverse(String str) {
        if (str.length() == 1) {
            return str;
        }

        return reverse(str.substring(1)) + str.substring(0, 1);
    }

    /**
     * 使用StringBuilder进行字符串翻转
     * @param str
     * @return
     */
    public static String reverseWithStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
