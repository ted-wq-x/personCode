package com.go2going.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_817 {
    /**
     * 15ms
     * @param head
     * @param G
     * @return
     */
    public int numComponents(ListNode head, int[] G) {
        int count = G.length;
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        ListNode pre = null;
        while (head != null) {
            if (pre != null) {
                if (set.contains(head.val) && set.contains(pre.val)) {
                    count--;
                }
            }
            pre = head;
            head = head.next;
        }

        return count;
    }


    /**
     * 4ms 使用数组替代set
     * @param head
     * @param G
     * @return
     */
    public int numComponents2(ListNode head, int[] G) {
        //长度
        int count = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            count++;
        }
        boolean[] cacahe = new boolean[count];
        for (int i : G) {
            cacahe[i] = true;
        }

        int ans = G.length;
        ListNode pre = null;
        while (head != null) {
            if (pre != null) {
                if (cacahe[head.val] && cacahe[pre.val]) {
                    ans--;
                }
            }
            pre = head;
            head = head.next;
        }

        return ans;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
