package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_142<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/25 0025 9:48
 */
public class LeetCode_142 {
    /**
     * 判断是否有环，入口的计算方法：
     * https://github.com/ted-wq-x/ted-wq-x.github.io/blob/master/img/leetCode_142.png
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //为什么换的入口在这，自己画图理解下就可以
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }

                return head;
            }
        }

        return null;
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
