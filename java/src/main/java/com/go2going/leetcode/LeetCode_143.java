package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_143<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/25 0025 15:36
 */
public class LeetCode_143 {

    public static void main(String[] args) {
        LeetCode_143 leetCode_143 = new LeetCode_143();

        ListNode f1 = leetCode_143.new ListNode(1);
        ListNode f2 = leetCode_143.new ListNode(2);
        ListNode f3 = leetCode_143.new ListNode(3);
        ListNode f4 = leetCode_143.new ListNode(4);

        f1.next = f2;
        f2.next = f3;
//        f3.next = f4;

        leetCode_143.reorderList(f1);

    }
    public void reorderList(ListNode head) {

        // step 1.找到中间点
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //把slow放到中间位置
        if (fast != null) {
            slow =  slow.next;
        }


        // step 2.翻转后半部分
        ListNode newHead=null,mid=slow;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = newHead;
            newHead = slow;
            slow = temp;
        }

        // step 3.交叉合并
        if (newHead == null) {
            return;
        }
        ListNode h = head;
        while (h != mid&&newHead!=null) {
            ListNode next = h.next;
            h.next = newHead;
            ListNode next1 = newHead.next;
            newHead.next = next;
            h = next;
            newHead = next1;
        }
        h.next=null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
