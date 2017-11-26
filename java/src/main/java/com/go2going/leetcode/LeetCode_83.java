package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/11/26 17:24
 */
public class LeetCode_83 {

    /**
     * AC解
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;

        ListNode pre = head;
        while (head != null) {
            if (head.val == pre.val) {
                head = head.next;
            } else {
                pre.next = head;
                pre = head;
                head = head.next;
            }
        }
        pre.next = null;
        return cur;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
