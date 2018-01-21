package com.go2going.leetcode;

/**
 * @author BlueT
 * 2018/1/21 19:00
 */
public class LeetCode_109 {

    /**
     * 高度平衡的bst，108很相似，但是链表无法直接计算出中间值，所以使用双指针的方式，找到中间的元素
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        return go(head, null);
    }

    /**
     * @param head 头指针
     * @param tail 尾指针
     * @return
     */
    private TreeNode go(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        //f1=slow,f2=fast,fast每次走两步,这样在f2到达尾部时，f1整好在中间
        ListNode f1 = head, f2 = head;

        //每次走两步，所以判断快指针是否越界
        while (f2 != tail && f2.next != tail) {
            f1 = f1.next;
            f2 = f2.next.next;
        }

        TreeNode node = new TreeNode(f1.val);
        node.left = go(head, f1);
        node.right = go(f1.next, tail);
        return node;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
