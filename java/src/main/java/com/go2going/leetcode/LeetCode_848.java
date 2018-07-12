package com.go2going.leetcode;

public class LeetCode_848 {
    public String shiftingLetters(String S, int[] shifts) {

        //计算出每个字符总的移动次数,然后一次性完成每个字符的移动
        long[] sum = new long[S.length()];

        /*for (int i : shifts) {
            sum[0] += i;
        }
        for (int i = 1; i < shifts.length; i++) {
            sum[i] = sum[i - 1] - shifts[i-1];
        }*/

        int length = shifts.length;
        sum[length-1] = shifts[length - 1];
        for (int i = length-2; i >=0; i--) {
            sum[i] = sum[i +1] + shifts[i];
        }

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            long val = chars[i] + sum[i];
            chars[i] = (char) ((val - 'a') % 26 + 'a');
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        LeetCode_848 leetCode_848=new LeetCode_848();
        System.out.println(leetCode_848.shiftingLetters("ruu", new int[]{26,9,17}));
    }
}
