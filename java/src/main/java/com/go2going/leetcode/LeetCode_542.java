package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode_542 {
    public static void main(String[] args) {
        LeetCode_542 scratch = new LeetCode_542();
        int[][] ints = scratch.updateMatrix(new int[][]{{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}});
        // int[][] ints = scratch.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
        System.out.println(Arrays.deepToString(ints));
    }


    /**
     * 103ms 这种思考方式没法简化，效率很低
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        // boolean[][] visited = new boolean[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                Set<Pair> remove = new HashSet<>();
                if (matrix[i][j] == 1) {
                    Pair e = new Pair(i, j);
                    remove.add(e);

                    ArrayDeque<Pair> list = new ArrayDeque<>();
                    list.add(e);
                    int sum = 0;
                    xx:
                    while (!list.isEmpty()) {
                        int size = list.size();
                        for (int k = 0; k < size; k++) {
                            Pair pop = list.pop();
                            if (matrix[pop.x][pop.y] == 0) {
                                break xx;
                            }

                            if (pop.x - 1 >= 0) {
                                Pair p = new Pair(pop.x - 1, pop.y);
                                if (!remove.contains(p)) {
                                    remove.add(p);
                                    list.addLast(p);
                                }
                            }
                            if (pop.y - 1 >= 0) {
                                Pair p = new Pair(pop.x , pop.y-1);
                                if (!remove.contains(p)) {
                                    remove.add(p);
                                    list.addLast(p);
                                }
                            }
                            if (pop.x+ 1 < x) {
                                Pair p = new Pair(pop.x + 1, pop.y);
                                if (!remove.contains(p)) {
                                    remove.add(p);
                                    list.addLast(p);
                                }
                            }
                            if (pop.y + 1 < y) {
                                Pair p = new Pair(pop.x , pop.y+1);
                                if (!remove.contains(p)) {
                                    remove.add(p);
                                    list.addLast(p);
                                }
                            }
                        }
                        sum++;
                    }
                    matrix[i][j] = sum;
                }
            }
        }

        return matrix;
    }

    class Pair{
        int x, y;

        public Pair(int x, int y) {

            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            if (y != pair.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }


    /**
     * dp,dp效率真的搞
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix2(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;

        int size = x * y;

        int[][] dp = new int[x][y];


        // -->
        // -- V
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int upValue = i - 1 >= 0 ? dp[i - 1][j] : size;
                    int leftValue = j - 1 >= 0 ? dp[i][j - 1] : size;
                    dp[i][j] = Math.min(upValue, leftValue) + 1;
                }

            }
        }

        // <--
        // ==^
        for (int i = x-1; i >= 0; i--) {
            for (int j = y - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    int bottomValue = i - 1 >= 0 ? dp[i + 1][j] : size;
                    int rightValue = j - 1 >= 0 ? dp[i][j + 1] : size;
                    dp[i][j] =  Math.min(Math.min(bottomValue, rightValue) + 1,dp[i][j]);
                }
            }
        }



        return dp;
    }
}
