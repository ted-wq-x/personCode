package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_92<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/18 0018 12:33
 */
public class LeetCode_92 {

    public static void main(String[] args) {
        LeetCode_92 t = new LeetCode_92();
        ListNode f1 = t.new ListNode(1);
        ListNode f2 = t.new ListNode(2);
        ListNode f3 = t.new ListNode(3);
        ListNode f4 = t.new ListNode(4);
        ListNode f5 = t.new ListNode(5);

        f1.next = f2;
        f2.next = f3;
        f3.next = f5;
        f4.next = f5;
        ListNode listNode = t.reverseBetween(f3, 1, 2);

        System.out.println(listNode);
    }

    /**
     * m<=n，有点难理解
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode index = res;
        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5
        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        for (int i = 0; i < m - 1; i++) {
            index = index.next;
        }

        ListNode start = index.next;
        ListNode then = start.next;


        for (int i = 0; i < n - m; i++) {
            //重点理解
            start.next = then.next;//开头的永远指向循环的最后一个
            then.next = index.next;//
            index.next = then;
            then = start.next;
        }


        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
}
