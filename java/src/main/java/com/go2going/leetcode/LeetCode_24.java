package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/17 15:34
 */
public class LeetCode_24 {
    /**
     * 自己理解,这个递归很有意思
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode n = head.next;

        head.next = swapPairs(head.next.next);

        n.next = head;
        return n;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
