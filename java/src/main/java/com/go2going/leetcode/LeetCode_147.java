package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_147<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/24 0024 11:22
 */
public class LeetCode_147 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 使用插入算法进行排序，从小到大
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        //辅助排序的，
        ListNode helper = new ListNode(0);

        //当前排序遍历的位置
        ListNode cur = head;

        //插入时进行比较的，辅助指针
        ListNode pre, next;

        while (cur != null) {
            next = helper.next;
            pre = helper;
            ListNode temp = cur.next;
            while (next != null) {
                if (next.val > cur.val) {
                    pre.next = cur;
                    cur.next = next;
                    break;

                } else {
                    pre = next;
                    next = next.next;
                }
            }

            //如果遍历到末尾，则需要将当前值放到末尾
            if (next == null) {
                pre.next = cur;
                cur.next = null;
            }

            cur = temp;
        }

        return helper.next;
    }


    public static void main(String[] args) {
        LeetCode_147 leetCode_147 = new LeetCode_147();
        ListNode head = leetCode_147.new ListNode(3);
        ListNode f1 = leetCode_147.new ListNode(4);
        ListNode f2 = leetCode_147.new ListNode(1);

        head.next = f1;
        f1.next = f2;

        ListNode listNode = leetCode_147.insertionSortList(head);

        System.out.println(listNode);
    }
}
