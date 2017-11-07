package com.go2going.sort;

import java.util.Arrays;

/**
 * 项目名称：  testcode<br>
 * 类名称：  HeapSort<br>
 * 描述：堆排序<br>
 * <a href="http://bubkoo.com/2014/01/14/sort-algorithm/heap-sort/">参考文章，需要理解文章中的变化过程</a>
 * <a href="https://zh.wikipedia.org/wiki/%E5%A0%86%E6%8E%92%E5%BA%8F#Java">wiki</a>
 *
 * @author wangqiang
 * 创建时间：  2017/11/7 0007 11:10
 */
public class HeapSort {

    private int[] arr;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    /**
     * 堆排序的主要入口方法，共两步。
     */
    public void sort() {

        //1.创建最大堆
        int length = arr.length - 1;
        int beginIndex = (length - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            heapMax(i, length);
        }

        //2.找到最大值，方队数组的最后，那么下次循环的时候就不用排序这个了
        for (int i = length; i > 0; i--) {
            swap(0, i);
            heapMax(0, i - 1);//i-1的意思得明白
        }
    }


    public void heapMax(int i, int length) {
        int left = (i << 1) + 1;//左节点
        int right = left + 1;//右节点

        //注意边界的判断，左边界直接返回
        if (left > length) {
            return;
        }

        //两个子节点的最大值和父节点比较
        int max = left;

        //有边界越界时，只需要比较左边界就行
        if (right <= length && arr[left] < arr[right]) {
            max = right;
        }

        if (arr[max] > arr[i]) {
            swap(max, i);
            heapMax(max, length);
        }
    }

    public void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    /**
     * 测试用例
     * <p>
     * 输出：
     * [0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9]
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        new HeapSort(arr).sort();
        System.out.println(Arrays.toString(arr));
    }

}