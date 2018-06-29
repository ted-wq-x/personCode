package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_148<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/24 0024 10:50
 */
public class LeetCode_148 {

    /**
     * 链表排序，时间复杂度(n logging n)，思想类似二分法，进行拆分排序，后进行合并
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        //step 1.切分成两半
        ListNode slowPre = null, fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        slowPre.next = null;

        //step 2.对这两半进行排序
        ListNode l1 = sortList((head));
        ListNode l2 = sortList((slow));

        //step 3.合并结果
        return merge(l1, l2);

    }

    /**
     * 对两个有序的listNode进行合并操作,我这边是从小到大排序
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        //head的next是返回值,temp记录当前的位置
        ListNode head = new ListNode(0), temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }

        //还剩下没有用到的节点,但是不肯能同时为null
        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }

        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
