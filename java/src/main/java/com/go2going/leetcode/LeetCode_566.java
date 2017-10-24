package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_566<br>
 * 描述：
 *
 *
 * @author wangqiang
 * 创建时间：  2017/10/24 0024 14:18
 */
public class LeetCode_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int lie = nums[0].length;
        int hang = nums.length;
        int sum = lie * hang;
        if (sum != r * c) {
            return nums;
        }

        int[][] res = new int[r][c];
        int oldh=0, oldl=0,h=0,l=0;//标记当前的位置

        for (int i = 0; i < sum; i++) {
            res[h][l++] = nums[oldh][oldl++];
            if (l >= c) {
                l=0;
                h++;
            }
            if (oldl >= lie) {
                oldl=0;
                oldh++;
            }
        }
        return res;
    }

    /**
     *  矩阵的技巧：定位坐标，h=行数，l=列数，sum=总数=h*l,按照先行后列的顺序取值时，取第i个值，坐标为i/l,i%l
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int lie = nums[0].length;
        int hang = nums.length;
        int sum = lie * hang;
        if (sum != r * c) {
            return nums;
        }

        if (lie ==c&&hang==r) {
            return nums;
        }


        int[][] res = new int[r][c];

        for (int i = 0; i < sum; i++) {
            res[i/c][i%c] = nums[i/lie][i%lie];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(4%4);
    }
}
