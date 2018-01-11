package com.go2going.leetcode;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_62<br>
 * 描述：学习：https://www.youtube.com/watch?v=fmpP5Ll0Azc
 *
 * @author wangqiang
 * 创建时间：  2018/1/10 0010 18:30
 */
public class LeetCode_62 {

    /**
     * 使用dp算法,使用记忆化递归，减少时间，思路很简单，某一个点到达的路径个数由上边的点+左边的点，所以就可以使用递归解决
     * 从a到b的路线个数，自己没什么好的想法
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];

        return find(m-1, n-1, ans);

    }

    private int find(int m, int n,int[][] ans) {
        if (m < 0 || n < 0) {
            return 0;
        }

        if (m == 0&& n == 0) {
            return 1;
        }

        if (ans[m][n] != 0) {
            return ans[m][n];
        } else {
            ans[m][n]= find(m - 1, n,ans) + find(m, n - 1,ans);
        }
        return ans[m][n];
    }

    /**
     * 从上往下，这个算法吊啊，人才，递推形式，ac解
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row,1);//第一行全是1
        for ( int i = 1; i < m; i++){//从第二行开始
            for ( int j = 1; j < n; j++){//从第二列开始，第一列都为1
                row[j]+=row[j-1];//在低i,j位置=上一行的值+左边的值，我靠6666666666
            }
        }
        return row[n-1];
    }
}
