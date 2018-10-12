package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode_130 {
    public static void main(String[] args) {
        LeetCode_130 leetCode_130 = new LeetCode_130();
        leetCode_130.solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }

    /**
     * 26.6%
     *
     * @param board
     */
    public void solve(char[][] board) {
        int height = board.length;
        if (height == 0) {
            return;
        }
        int length = board[0].length;

        if (height <= 1 || length <= 1) {
            return;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < height; i++) {
            for (int y = 0; y < length; y++) {
                if (board[i][y] == 'O') {
                    if (i == 0 || y == 0 || i == height - 1 || y == length - 1) {
                        queue.add(new int[]{i, y});
                        board[i][y] = '1';
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = '1';
                queue.add(new int[]{x - 1, y});
            }
            if (x + 1 <= height - 1 && board[x + 1][y] == 'O') {
                board[x + 1][y] = '1';
                queue.add(new int[]{x + 1, y});
            }

            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = '1';
                queue.add(new int[]{x, y - 1});
            }
            if (y + 1 <= length - 1 && board[x][y + 1] == 'O') {
                board[x][y + 1] = '1';
                queue.add(new int[]{x, y + 1});
            }
        }
        for (int i = 0; i < height; i++) {
            for (int y = 0; y < length; y++) {
                if (board[i][y] == 'O') {
                    board[i][y] = 'X';
                } else if (board[i][y] == '1') {
                    board[i][y] = 'O';
                }
            }
        }

    }

}
