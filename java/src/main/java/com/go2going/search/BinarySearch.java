package com.go2going.search;

/**
 * 项目名称：  testcode<br>
 * 类名称：  BinarySearch<br>
 * 描述：在有序数组中查找
 *
 * @author wangqiang
 * 创建时间：  2017/11/8 0008 18:27
 */
public class BinarySearch {

    /**
     * 方法名：  searchCirculation
     * 描述：  使用循环的二分查找
     *
     * @param
     * @return
     * @author 王强
     * 创建时间：2017年11月08日 18:29:33
     */
    public static int searchCirculation(int[] arr, int target) {

        int length = arr.length;
        int mid;
        int left = 0, right = length - 1;
        while (left <= right) {//注意==
            //折半
            mid = (left + right) >> 1;

            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 使用递归实现
     *
     * @param arr
     * @param target
     * @return
     */
    public static int searchRecursive(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }

    private static int search(int[] arr, int target, int l, int r) {
        if (l > r) {//注意没有==
            return -1;
        }
        int mid = (l + r) >> 1;
        if (arr[mid] > target) {
            return search(arr, target, l, mid - 1);
        } else if (arr[mid] < target) {
            return search(arr, target, mid + 1, r);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 34, 66, 80};

        System.out.println(searchCirculation(arr, 667));
        System.out.println(searchRecursive(arr, 667));
    }
}
