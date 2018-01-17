package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_79<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/17 0017 9:32
 */
public class LeetCode_79 {
    /**
     * 题目的意思是，以每一个元素作为出发点，向四个方向查找，也就是word单词的字母是相邻的
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int x, y;
        if ((y = board.length) == 0 || (x = board[0].length) == 0) return false;


        /**
         * 以每个元素作为出发点
         */
        for (int i = 0; i < y; i++) {//行
            for (int j = 0; j < x; j++) {//列

                if (exist(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;

    }


    /**
     *
     * @param board
     * @param word
     * @param index
     * @param i
     * @param j
     * @return
     */
    public boolean exist(char[][] board, String word, int index, int i, int j) {

        if (index == word.length()) {
            return true;
        }

        //判断是否越界，以及相等
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        //标记已经遍历过的
        board[i][j] = '*';

        //判断四个方向的元素是否等于下一个字符
        boolean res = exist(board, word, index + 1, i - 1, j) ||
                exist(board, word, index + 1, i + 1, j) ||
                exist(board, word, index + 1, i , j-1) ||
                exist(board, word, index + 1, i, j+1);
        //还原标记
        board[i][j] = word.charAt(index);
        return res;
    }
}
