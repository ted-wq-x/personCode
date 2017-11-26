package com.go2going.leetcode;


/**
 * @author BlueT
 * 2017/11/26 18:34
 */
public class LeetCode_67 {
    /**
     * 这种方式，对于太长的字符串不行
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a, String b) {

        int a1 = 0;
        int length1 = a.length();
        for (int i = 0; i < length1; i++) {
            a1 += (a.charAt(length1-1-i)-'0') * (1 << i);
        }

        int a2 = 0;
        int length = b.length();
        for (int i = 0; i < length; i++) {
            a2 += (b.charAt(length-i-1) -'0')* (1 << i);
        }

        return Integer.toBinaryString(a1+a2);
    }

    /**
     * 3ms
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int al = a.length();
        int bl = b.length();

        StringBuilder sb = new StringBuilder();
        int length;
        if (al < bl) {
            length = bl;
            int t = bl - al;
            for (int i = 0; i < t; i++) {
                sb.append(0);
            }
            a = sb.toString() + a;
        } else {
            length = al;
            int t = al - bl;
            for (int i = 0; i < t; i++) {
                sb.append(0);
            }
            b = sb.toString() +b;
        }

        //将字符串变成一样长
        sb = new StringBuilder();
        int temp = 0;

        for (int i = 0; i < length; i++) {
            temp = getTemp(a, b, sb, temp, length - i - 1);
        }

        //注意最后一个清理
        if (temp == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    /**
     * 进位
     * @param a
     * @param b
     * @param sb
     * @param temp 进位
     * @param index
     * @return 进位
     */
    private int getTemp(String a, String b, StringBuilder sb, int temp, int index) {
        int im = (a.charAt(index) - '0') + (b.charAt(index) - '0')+temp;
        if (im == 2) {
            temp = 1;
            sb.append(0);
        } else if (im == 1) {
            temp = 0;
            sb.append(1);
        } else if (im == 3) {
            temp = 1;
            sb.append(1);
        } else {
            sb.append(0);
        }
        return temp;
    }

    public static void main(String[] args) {
        LeetCode_67 leetCode_67 = new LeetCode_67();
        System.out.println(leetCode_67.addBinary("1", "111"));
    }
}
