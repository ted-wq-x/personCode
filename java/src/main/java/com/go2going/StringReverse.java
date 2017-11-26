package com.go2going;

/**
 * @author BlueT
 * 2017/11/26 11:37
 */
public class StringReverse {
    public static void main(String[] args) {
        System.out.println(reverse("my name is wq"));

    }


    /**
     * 函数式，使用参数保存状态
     * @param str
     * @return
     */
    public static String reverse(String str){

        if (str.length() == 1) {
            return str;
        }

        return reverse(str.substring(1, str.length())) + str.substring(0, 1);

    }
}
