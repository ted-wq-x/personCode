package com.go2going.leetcode;


/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_31<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/17 0017 10:51
 */
public class LeetCode_31 {

    /**
     * 还是挺难的，需要找到规律，好难，没看懂，TODO
     * 0,1,2,3,4,5
     * 1,2,3,7,3,4
     *
     * @param num
     */
    public void nextPermutation(int[] num) {
        int n = num.length;
        if (n < 2)
            return;
        int index = n - 1;
        //从后往前找到第一个后面比前面大的元素位置
        while (index > 0) {
            if (num[index - 1] < num[index])//找到的是4，但是index是4的
                break;
            index--;
        }
        if (index == 0) {
            //如果是从大到小排序，则交换第一个和最后一个
            reverseSort(num, 0, n - 1);
        } else {
            int val = num[index - 1];//
            int j = n - 1;
            while (j >= index) {
                if (num[j] > val)//j=5
                    break;
                j--;
            }
            swap(num, j, index - 1);//交换3,4
            reverseSort(num, index, n - 1);//防止出现最小的情况
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private void reverseSort(int[] num, int start, int end) {
        if (start > end)
            return;
        for (int i = start; i <= (end + start) / 2; i++)
            swap(num, i, start + end - i);
    }

}
