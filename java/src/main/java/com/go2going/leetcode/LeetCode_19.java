package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/17 14:26
 */
public class LeetCode_19 {
    /**
     * 根据题意n的值是合法的
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //slowBefore记录slowTemp的前一个，当fastTemp=null,那么slowTemp就是需要删除的节点
        ListNode slowBefore = null, fastTemp = head, slowTemp = head;

        //使用快慢指针
        for (int i = 0; i < n; i++) {
            fastTemp = fastTemp.next;
        }

        while (fastTemp != null) {
            slowBefore = slowTemp;
            slowTemp = slowTemp.next;
            fastTemp = fastTemp.next;
        }

        if (slowBefore == null) {
            head = head.next;
        } else {

            slowBefore.next = slowTemp.next;
        }

        return head;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
