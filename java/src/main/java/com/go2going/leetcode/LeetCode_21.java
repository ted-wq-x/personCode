package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_21<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 18:58
 */
public class LeetCode_21 {

    /**
     * 这种递归方式，在第一执行的时候就返回值了，只不过在返回之前进行了递归合并，有意思啊！！！
     * @param l1
     * @param l2
     * @return 节点的值时从小到大
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
