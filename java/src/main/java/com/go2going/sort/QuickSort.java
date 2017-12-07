package com.go2going.sort;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  QuickSort<br>
 * 描述：快速排序：
 *
 * @author wangqiang
 * 创建时间：  2017/11/7 0007 18:15
 */
public class QuickSort {


    /**
     * 找出基准，将比基准小的放到左边，大的放到右边，递归排序左边和右边
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length - 1);

    }

    public static void sort(int[] arr, int start, int end) {
        //将会第一个数作为中立元素

        int mid = arr[(start + end) / 2];

        //双指针逼近
        int i = start, j = end;

        while (i <= j) {
            //从左往右找比mid大的。从右往左找比mid小的，然后交换，相等的也要交换
            while (arr[i] < mid) {
                i++;
            }
            while (arr[j] > mid) {
                j--;
            }
            if (i <= j) {
                //交换过的就不用比较了
                swap(arr, i++, j--);
            }
        }

        //递归调用左右两边的组数
        if (j > start) {
            sort(arr, start, j);
        }
        if (i < end) {
            sort(arr, i, end);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        //                int[] a = {10,2,3,4,5};
        //        int[] a = {12, 33, 54, 23, 58, 5, 5, 888};
        int[] a = {1, 33, 2, 23, 58, 5, 5, 2};

        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
