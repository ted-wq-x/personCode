package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_82<br>
 * 描述：虽然是esay难道，但是对我却很有意思
 *
 * @author wangqiang
 * 创建时间：  2017/11/16 0016 20:45
 */
public class LeetCode_82 {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }


        if (head.next != null && head.val == head.next.val) {

            //找到第一个和head不同的节点
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            //这里很有意思，此处是亮点，将之前所有的重复元素去除掉
            return deleteDuplicates(head.next);
        } else {
            //当前值和下一个值不相等，那么当前值可用，下一个值就递归调用（deleteDuplicates的返回值就是不重复的）
            head.next = deleteDuplicates(head.next);
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
