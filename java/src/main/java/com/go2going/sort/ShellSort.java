package com.go2going.sort;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  ShellSort<br>
 * 描述：希尔排序
 * 是插入排序的一种更高效的改进版本。希尔排序是非稳定排序算法。
 *
 * @author wangqiang
 * 创建时间：  2017/11/7 0007 10:27
 */
public class ShellSort {
    public static void sort(int[] a) {
        int length = a.length;

        //步长生成算法
        int h = 1;
        while (h < length/3) h = 3*h + 1;

        while (h >= 1) {
            for (int i = h; i < length; i++) {
                //当前指针和前一个指针相比
                for (int j = i; j >=h; j-=h) {
                    if (a[j-h] > a[j]) {
                        //交换元素
                        int temp = a[j];

                        a[j] = a[j-h];

                        a[j-h] = temp;
                    } else {
                        break;
                    }
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        int[] a = {112, 33, 54, 23, 58, 5,5};

        sort(a);

        System.out.println(Arrays.toString(a));
    }
}
