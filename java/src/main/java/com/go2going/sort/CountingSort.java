package com.go2going.sort;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  CountingSort<br>
 * 描述：计数排序：需要很大的辅助空间
 *
 * @author wangqiang
 * 创建时间：  2017/11/14 0014 13:55
 */
public class CountingSort {
    public static void sort(int[] arr){


        int max = Integer.MIN_VALUE;//还可以计算最小值

        //获取数组最大值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }


        int[] temp = new int[max+1];

        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }

        int s = 0;//记录已经使用的指针位置

        for (int i = 0; i < arr.length; i++) {

            for (int j = s; j < temp.length; j++) {
                if (temp[j] != 0) {
                    arr[i] = j;
                    temp[j]--;
                    break;
                }
            }
        }

    }


    public static void main(String[] args) {
        int[] ints = {22, 1, 3, 999, 23, 545, 6, 4, 66, 72, 6};
        CountingSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
