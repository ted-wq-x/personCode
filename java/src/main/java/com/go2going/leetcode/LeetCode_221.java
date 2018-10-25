package com.go2going.leetcode;

public class LeetCode_221 {

    /**
     * 34.82%
     * 12ms
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int lie = matrix.length;
        if (lie == 0) {
            return 0;
        }
        int hang = matrix[0].length;
        int max = 0;
        for (int x = 0; x < lie; x++) {
            for (int y = 0; y < hang; y++) {
                //这个剪枝，浪费时间
                /*if (lie - x < max || hang - y < max) {
                    return max*max;
                }*/
                if (matrix[x][y] == '0') {
                    continue;
                }

                int sum = 1;

                //取最大矩阵
                int m = x, n = y;
                while (++m < lie && ++n < hang) {
                    boolean go = true;
                    for (int i = y; i <= n; i++) {
                        if (matrix[m][i] == '0') {
                            go = false;
                            break;
                        }
                    }
                    if (!go) {
                        break;
                    }
                    for (int i = x; i <= m; i++) {
                        if (matrix[i][n] == '0') {
                            go = false;
                            break;
                        }
                    }
                    if (go) {
                        sum++;
                    } else {
                        break;
                    }

                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max * max;
    }

    /**
     * dp 8ms 95.62%
     * @param a
     * @return
     */
    public int maximalSquare2(char[][] a) {
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == '1') {
                    //dp 只要有一个是0，那么就会变成1
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
    }
}
