package com.go2going.sort;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  BubbleSort<br>
 * 描述：泡沫排序
 *
 * @author wangqiang
 * 创建时间：  2017/11/7 0007 10:31
 */
public class BubbleSort {
    public static void sort(int[] a) {
        int length = a.length;

        for (int i = 0; i < length; i++) {
            //每一次的遍历，获取从i到length-1之间的最小值
            for (int j =length-1; j >i; j--) {
                if (a[j] < a[j - 1]) {
                    //交换元素
                    int temp = a[j];

                    a[j] = a[j-1];

                    a[j-1] = temp;
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
