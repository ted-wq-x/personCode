package com.go2going.sort;

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
    int[] arr;

    public void sort(int[] arr) {

    }


    public void quickSort(int start,int end) {


        if (start >= end) {
            return;
        }


        int mid = arr[end];


        while (start < end) {

        }

    }
    private void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
