package com.go2going.leetcode;

public class LeetCode_725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];

        int deep = 0;
        ListNode temp = root;
        while (temp != null) {
            deep++;
            temp = temp.next;
        }

        if (k >= deep) {
            for (int i = 0; i < ans.length; i++) {
                ans[i] = root;
                root = part(root, 1);
            }

        } else {
            int base = deep / k;
            int i1 = deep % k;
            for (int i = 0; i < ans.length; i++) {
                ans[i] = root;
                int length = base + (i1-- > 0 ? 1 : 0);
                root = part(root, length);
            }
        }


        return ans;
    }

    /**
     * @param root
     * @param length
     * @return 被裁剪的部分，结束
     */
    private ListNode part(ListNode root, int length) {
        if (length == 0 || root == null) {
            return null;
        }
        ListNode ans;

        while (true) {
            length--;
            if (length == 0) {
                ans = root.next;
                root.next = null;
                break;
            }
            root = root.next;
        }
        return ans;
    }
}
