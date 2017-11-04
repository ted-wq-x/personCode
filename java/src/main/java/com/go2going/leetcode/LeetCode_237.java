package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/11/4 22:26
 */
public class LeetCode_237 {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
