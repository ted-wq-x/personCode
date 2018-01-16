package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCod_74<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/16 0016 12:31
 */
public class LeetCod_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        if (length == 0) {
            return false;
        }
        int index = matrix[0].length;
        if (index == 0) return false;
        for (int i = 0; i < length; i++) {
            if (matrix[i][index - 1] >= target) {
                if (matrix[i][0] > target) return false;
                if (matrix[i][index - 1] == target)  return true;
                for (int j = 0; j < index; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * 二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int length = matrix.length;
        if (length == 0) {
            return false;
        }
        int index = matrix[0].length;
        if (index == 0) return false;


        int l = 0, r = length * index - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;

            int i = matrix[mid / index][mid % index];
            if (i < target) {
                l = mid + 1;
            } else if (i == target) {
                return true;
            } else {
                r = mid - 1;
            }

        }
        return false;
    }
}
