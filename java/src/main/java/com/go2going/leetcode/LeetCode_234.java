package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/4 23:42
 */
public class LeetCode_234 {

    /**
     * 判断是否为回文链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        String s = sb.toString();
        return   sb.reverse().toString().equals(s);
    }



    public static void main(String[] args) {
        ListNode f1 = new ListNode(1);
        ListNode f2 = new ListNode(2);
        ListNode f3 = new ListNode(3);
        ListNode f4 = new ListNode(4);
        ListNode f5 = new ListNode(5);
        f1.next = f2;
        f2.next = f3;
        f3.next = f4;
        f4.next = f5;
        LeetCode_234 leetCode_234 = new LeetCode_234();
        leetCode_234.isPalindrome(f1);
    }

    /**
     * 反转
     * @param node
     * @return
     */
    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}