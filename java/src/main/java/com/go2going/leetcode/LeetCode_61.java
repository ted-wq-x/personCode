package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_61<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/5 0005 10:23
 */
public class LeetCode_61 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 题目的意思是向右移动k位
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null||k==0) {
            return head;
        }
        //使用快慢指针
        ListNode first = head,slowIndex=head,fastIndex=head;

        //定位快指针位置
        int i = 1;
        while (i <= k) {
            fastIndex = fastIndex.next;
            if (fastIndex == null) {
                //当k大于head的长度
                k = k % i;
                i = 1;
                fastIndex = first;
            } else {
                i++;
            }
        }

        //确定指针的最终位置
        while (fastIndex.next!=null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }


        ListNode newFirst = slowIndex.next;
        if (newFirst == null) {
            return first;
        }
        slowIndex.next=null;
        fastIndex.next = first;
        return newFirst;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(rotateRight(head, 3));
    }


}
