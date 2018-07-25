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

    /**
     * 堆排序的主要入口方法，共两步。
     */
    public void sort() {

        //1.创建最大堆
        int length = arr.length;
        int beginIndex = (length - 1) >> 1;
        //i都是有子节点的根节点
        for (int i = beginIndex; i >= 0; i--) {
            heapMax(i, length);
        }

        //构建玩最大堆之后，还不能保证左右节点的大小，只知道根节点最大

        //2.找到最大值，方队数组的最后，那么下次循环的时候就不用排序这个了
        for (int i = length-1; i > 0; i--) {
            swap(0, i);
            //将最大值放到最后，然后重新构建
            heapMax(0, i );
        }
    }

    /**
     * left和right+1的原因是在计算beginIndex的位置时就少了1，因为下标是从0开始的
     *
     * @param i
     * @param length
     */
    public void heapMax(int i, int length) {
        int left = (i << 1) + 1;//左节点
        int right = left + 1;//右节点
        int maxIndex = i;

        if (left < length && arr[left] > arr[maxIndex]) {
            maxIndex = left;
        }

        if (right < length && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != i) {
            swap(maxIndex, i);
            //递归调整
            heapMax(maxIndex, length);
        }

    }

    public void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}