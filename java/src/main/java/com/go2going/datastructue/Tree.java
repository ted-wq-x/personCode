package com.go2going.datastructue;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Tree<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/24 0024 8:54
 */
public class Tree {
    // 二叉树的节点
    class TreeNode<E extends Comparable<E>> {

        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }


    //给定有序查找表array 二分查找给定的值data
    //查找成功返回下标 查找失败返回-1
    static int funBinSearch(int[] array, int data) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (data == array[mid]) {
                return mid;
            } else if (data < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println("o".equals(null));
    }
}
