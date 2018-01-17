package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_86<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/17 0017 10:05
 */
public class LeetCode_86 {

    /**
     * 计数是从0开始，题目意思是，使得所有小于x的节点都在x大于或等于x的节点之前。，保留原有元素的顺序
     * 题目没难度，但是不能理解错
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {

        ListNode small = null, big = null, smallFirst = null, bigFirst = null;


        while (head != null) {
            if (head.val >= x) {
                if (big == null) {
                    big = head;
                    bigFirst = head;
                } else {
                    big.next = head;
                    big = head;
                }

            } else if (head.val < x) {
                if (small == null) {
                    small = head;
                    smallFirst = head;
                } else {
                    small.next = head;
                    small = head;
                }
            }


            head = head.next;
        }
        if (small == null) {
            return bigFirst;
        }

        //最后的节点不能忘
        if (big != null) {
            big.next = null;
        }

        small.next = bigFirst;
        return smallFirst;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
