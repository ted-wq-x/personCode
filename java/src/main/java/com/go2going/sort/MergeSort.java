package com.go2going.sort;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  MergeSort<br>
 * 描述：归并排序(动图就像打麻将)
 * <a href="https://zh.wikipedia.org/wiki/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F#Java">wiki的动态图很形象</a>
 *
 * @author wangqiang
 * 创建时间：  2017/11/7 0007 16:10
 */
public class MergeSort {

    //需要额外的存储空间
    static int[] temp=null;

    public static void sort(int start, int end, int[] arr) {
        if (start >= end) {
            return;
        }

        int start1 = start, end1 = ((end-start) >> 1) + start;
        int start2 = end1 + 1, end2 = end;
        sort(start1,end1,arr);
        sort(start2,end2,arr);


        int tempIndex = start;
        //到这里，在start1--end1和start2--end2中分别都是有序的，也就是对两个有序的进行合并操作
        //按照上面的代码end1必然小于start1
        while (start1 <= end1 && start2 <= end2) {
            //如果直接在tempIndex中取值设置，则会覆盖数据，结果就不对了
            temp[tempIndex++] = arr[start1] > arr[start2] ? arr[start2++] : arr[start1++];
        }

        //两个数组没用完的情况
        while (start2 <= end2) {
            temp[tempIndex++] =  arr[start2++] ;
        }
        while (start1 <= end1) {
            temp[tempIndex++] = arr[start1++];
        }

        //不能省，在使用while的时候得需要
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }

    }

    public static void merge_sort(int[] arr) {
        temp = new int[arr.length];
        sort(0, arr.length - 1, arr);

        //结束的时候temp和arr的数据是一样的
    }

    public static void main(String[] args) {
        int[] a = {112, 33, 54, 23, 58, 5, 5};
        merge_sort(a);
        System.out.println(Arrays.toString(a));
    }
}
