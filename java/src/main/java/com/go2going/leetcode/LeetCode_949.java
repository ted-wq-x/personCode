package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode_949 {
    public static void main(String[] args) {
        LeetCode_949 leetCode_949=new LeetCode_949();
        System.out.println( leetCode_949.largestTimeFromDigits(new int[]{1, 2, 3, 4}));
    }

    /**
     * easy 有点意思，解法和我的思路是一样的，但是其生成24个组合的方式我没有想到，这题搞了好久
     * @param A
     * @return
     */
    public String largestTimeFromDigits(int[] A) {
        //  LinkedList<String> q = new LinkedList<>(); 19ms
        Queue<String> q = new ArrayDeque<>(); //14ms
        q.add("");

        for (int n :A){
            for (int size = q.size(); size > 0; size--) {
                String s = q.poll();
                //将当前的n插入到已经生成的字符串的左右位置
                for (int i = 0; i <= s.length(); i++)
                    q.add(s.substring(0, i) + n + s.substring(i));
            }
        }
        //在生成的24个组合中找到合法的最大值
        String largest = "";
        for (String s : q) {
            s = s.substring(0, 2) + ":" + s.substring(2);
            //秒数不能大于6开头
            if (s.charAt(3) < '6' && s.compareTo("24:00") < 0 && s.compareTo(largest) > 0)
                largest = s;
        }
        return largest;



    }
}
