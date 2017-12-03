package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/12/3 16:39
 */
public class LeetCode_160 {

    /**
     * 但是我觉的题目是有毛病的，例如相同又不同，咋整，题目没说明
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA), lenB = length(headB);
        // move headA and headB to the same start point
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        //链一样长，找到以第一相同的，返回
        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }


    /**
     * 计算链的长度
     * @param node
     * @return
     */
    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
