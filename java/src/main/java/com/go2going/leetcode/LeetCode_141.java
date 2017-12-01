package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_141<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/1 0001 11:08
 */
public class LeetCode_141 {


    /**
     * 使用双指针判断，当快的指针==慢的指针时说明存在环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode walk=head, run=head;
        while (true) {
            //快的走前面，所以只要判断快的就行
            if (run.next == null || run.next.next == null) {
                return false;
            }

            walk = walk.next;
            run = run.next.next;

            if (run == walk) {
                return true;
            }

        }

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
