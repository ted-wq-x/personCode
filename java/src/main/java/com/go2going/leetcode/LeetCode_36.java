package com.go2going.leetcode;

import java.util.HashSet;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_36<br>
 * 描述：判断数独板是否合法
 *
 * @author wangqiang
 * 创建时间：  2017/12/26 0026 16:29
 */
public class LeetCode_36 {

    /**
     * 这个题目我的理解有点问题，看了别人的答案之后明白了，只要判断数字是否符合规则就行，这样一来就比较简单了
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            //i指的是行，列，和单元格
            //可以把HashSet换成boolean二位数组
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            int RowIndex = 3 * (i / 3);
            int ColIndex = 3 * (i % 3);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;
                //注意计算行列的方式
                int indexI = RowIndex + j / 3;
                int indexJ = ColIndex + j % 3;
                if (board[indexI][indexJ] != '.' && !cube.add(board[indexI][indexJ]))
                    return false;
            }
        }
        return true;
    }
}
