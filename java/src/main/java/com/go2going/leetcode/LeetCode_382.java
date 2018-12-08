package com.go2going.leetcode;

import java.util.Random;

public class LeetCode_382 {

    class Solution {

        private Random random;

        private int size;
        private ListNode node;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.node = head;
            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }
            size = count;
            random=new Random();
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int s = random.nextInt(size);
            if (s == 0) {
                return node.val;
            } else {
                ListNode head = node;
                while (s > 0) {
                    head = head.next;
                    s--;
                }
                return head.val;
            }
        }
    }

     class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
class Solution2 {

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    private ListNode head;
    private Random random;

    /**
     * ((n-1/n)*(n-2/n-1)*...*(1/2) = 1/n)
     * @param head
     */
    public Solution2(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    // n = 1    n = 2    n = 3
    // node1 -> node2 -> node3
    // [0, 1)   [0, 2)   [0, 3)
    public int getRandom() {
        if(head == null) return -1;
        ListNode node = head;
        int res = node.val;
        int n = 1;  // index of node
        while(node.next != null){
            node = node.next;
            if(random.nextInt(n+1) == n){
                res = node.val;
            }
            n++;
        }
        return res;
    }
}
}
