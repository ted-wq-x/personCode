package com.go2going.sort;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  InsertionSort<br>
 * 描述：插入排序
 *
 * @author wangqiang
 * 创建时间：  2017/11/7 0007 9:52
 */
public class InsertionSort {

    /**
     * 特点：
         运行时间和输入有关，当输入已排序时，时间复杂度是O(n);
         For partially-sorted arrays, insertion sort runs in linear time.(交换的次数等于输入中倒置(inversion)的个数)
         插入排序适合部分有序数组，也适合小规模数组
     * @param a
     */
    public static void sort(int[] a) {
        int length = a.length;

        for (int i = 1; i < length; i++) {

            //当前指针和前一个指针相比
            for (int j = i; j >0; j--) {
                if (a[j-1] > a[j]) {
                    //交换元素
                    int temp = a[j];

                    a[j] = a[j-1];

                    a[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {112, 33, 54, 23, 58, 5,5};

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
