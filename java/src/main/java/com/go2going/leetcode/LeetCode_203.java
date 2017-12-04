package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_203<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/4 0004 9:55
 */
public class LeetCode_203 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode node = head;
        ListNode pre = null;
        while (node != null) {
            if (node.val == val) {
                if (pre == null) {
                    node = node.next;
                    head = node;//当删除的是头节点时，需要重新设置头
                } else {
                    pre.next = node.next;
                    node = node.next;
                }
            } else {
                pre = node;
                node = node.next;
            }
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
