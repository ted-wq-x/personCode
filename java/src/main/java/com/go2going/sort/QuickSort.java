package com.go2going.sort;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  QuickSort<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/7 0007 18:15
 */
public class QuickSort {

//    TODO
static int[] arr;

    public static void quickSort(int[] arr) {
        QuickSort.arr = arr;
        sort( 0, arr.length-1);

    }

    public static void sort(int start, int end) {
        if (start >= end) {
            return;
        }

        int index = partition(start, end);
        if (index - 1 > start) {
            sort(start, index - 1);
        }
        if (index + 1 < end) {
            sort(index+1, end);
        }
    }


    public  static int partition(int start,int end) {

        int mid = arr[start];

        int i = start + 1,j=end;

        while (i < j) {
            while (arr[i] <= mid&&i<end) {
                i++;
            }
            while (arr[j] >= mid&&j>start) {
                j--;
            }
            swap(i, j);

        }
        swap(start, i);
        return j;//j==i
    }
    private static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main(String[] args) {
        int[] a = {12, 33, 54, 23, 58, 5, 5,888};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
