package com.go2going.leetcode;

public class LeetCode_955 {
    public static void main(String[] args) {
        LeetCode_955 leetCode_955 = new LeetCode_955();
        // System.out.println(leetCode_955.minDeletionSize(new String[]{"ca", "bb", "ac"})==1);
        // System.out.println(leetCode_955.minDeletionSize(new String[]{"xc","yb","za"})==0);
        // System.out.println(leetCode_955.minDeletionSize(new String[]{"zyx","wvu","tsr"})==3);
        // System.out.println(leetCode_955.minDeletionSize(new String[]{"xga", "xfb", "yfa"}) == 1);
        // System.out.println(leetCode_955.minDeletionSize(new String[]{"abx","agz","bgc","bfc"}) == 1);
        System.out.println(leetCode_955.minDeletionSize(new String[]{"doeeqiy","yabhbqe","twckqte"}) == 3);
    }

    //按单词比较，不能按位置比较 ,7ms
    public int minDeletionSize(String[] A) {
        int count = 0;
        int length = A.length;
        if (length == 1) {
            return 0;
        }

        int word_length = A[0].length();

        boolean[] cache = new boolean[word_length];
        String bef = A[0];
        for (int i = 1; i < length; i++) {
            String cur = A[i];
            boolean reset=false;
            for (int j = 0; j < word_length; j++) {
                if (cache[j]) {
                    continue;
                }
                char c1 = bef.charAt(j);
                char c2 = cur.charAt(j);
                if (c1 < c2) {
                    break;
                } else if (c1 == c2) {
                    continue;
                } else {
                    //c1>c2
                    cache[j] = true;
                    count++;
                    reset = true;
                }
            }
            if (reset) {
                bef = A[0];
                i = 0;
            } else {
                bef = cur;
            }

        }


        return count;
    }
}
