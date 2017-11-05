package com.go2going.leetcode;

/**
 * 单链表反转
 * @author BlueT
 * 2017/11/5 17:16
 */
public class LeetCode_206 {

    /**
     * https://www.youtube.com/watch?v=esl_A_pzBcg
     *
     * 1->2->3->4
     * null ->1 ->2 ->3->4
     * pre->cur->next
     *      pre->cur->next
     *      ...
     * 1<-2<-3<-4
     *
     * 将cur的next设置为pre
     *
     * 第一次遇到，理解起来有点困难
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = pre;//head理解成current，将current的next设置为pre
            pre = head ;//更新pre，为current
            head = next;//更新current，为next
        }

        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
