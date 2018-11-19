package com.go2going.leetcode;

public class LeetCode_944 {
    /**
     * 题目真的看不懂
     * 删除之后使得每个元素非递减，返回删除的索引数组长度的最小值
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
        int length = A[0].length();
        int deletions = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < A.length-1; j++){

                if(A[j].charAt(i) > A[j+1].charAt(i)){
                    deletions++;
                    break;
                }
            }
        }
        return deletions;
    }
}
