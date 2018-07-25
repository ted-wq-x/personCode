package com.go2going.leetcode;

public class LeetCode_215 {
    
    private int[] array;

    /**
     * medium
     * 堆排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        array = nums;

        int length = nums.length;

        int beginIndex = (length << 1) - 1;

        for (int i = beginIndex; i >=0; i--) {
            heapMax(i, length);
        }

        for (int i = length-1; i >0; i--) {
            swap(0, i);
            heapMax(0,i);
        }

        return nums[length-k];
    }

    public void heapMax(int i, int length) {
        int left = (i << 1) + 1;//左节点
        int right = left + 1;//右节点
        int maxIndex = i;

        if (left < length && array[left] > array[maxIndex]) {
            maxIndex = left;
        }

        if (right < length && array[right] > array[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != i) {
            swap(maxIndex, i);
            //递归调整
            heapMax(maxIndex, length);
        }

    }

    public void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

   
}
