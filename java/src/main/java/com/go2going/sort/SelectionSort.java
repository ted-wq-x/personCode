package com.go2going.sort;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  SelectionSort<br>
 * 描述：选择排序
 * 在剩余元素中选择最小的进行排序
 *
 * @author wangqiang
 * 创建时间：  2017/11/7 0007 9:24
 */
public class SelectionSort {


    /**
     * 特点：
     *   运行时间和输入无关，无论输入是已排序，时间复杂度都是O(n^2)
     *   数据移动最少，交换的次数和数组大小是线性关系
     * @param a
     */
    public static void sort(int[] a) {
        int length = a.length;

        for (int i = 0; i < length; i++) {
            int min = i;

            for (int j = i+1; j < length; j++) {
                if(a[j]<a[min]) min = j;
            }

            //交换元素
            int temp = a[i];

            a[i] = a[min];

            a[min] = temp;
        }
    }


    public static void main(String[] args) {
        int[] a = {112, 33, 54, 23, 58, 5};

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
