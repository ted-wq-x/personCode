package com.go2going.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_82<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/16 0016 20:45
 */
public class LeetCode_82 {
    public ListNode deleteDuplicates(ListNode head) {

        Set<Integer> set = new LinkedHashSet<>();

        while (head != null) {
            int val = head.val;
            System.out.println(val);
            if (!set.add(val)) {
                set.remove(val);
            }
            head = head.next;
        }
        ListNode root = null;

        for (Integer integer : set) {
            if (root == null) {
                root = new ListNode(integer);
            } else {
                root.next = new ListNode(integer);
            }
        }

        return root;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
