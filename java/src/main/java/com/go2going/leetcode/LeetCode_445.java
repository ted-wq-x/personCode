package com.go2going.leetcode;

/**
 * medium
 * @author BlueT
 * 2018/7/14 23:20
 */
public class LeetCode_445 {
    public static void main(String[] args) {
        LeetCode_445 leetCode_445=new LeetCode_445();
        ListNode l1=new ListNode(7), l2=new ListNode(5);
        ListNode next = new ListNode(2);
        l1.next = next;
        ListNode next1 = new ListNode(4);
        next.next = next1;
        next = next1;
        next1 = new ListNode(3);
        next.next = next1;

        next= new ListNode(6);
        l2.next= next;
        next.next=new ListNode(4);

        leetCode_445.addTwoNumbers(l1, l2);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String  i1 = toString(l1);
        String i2 = toString(l2);

        // 到这里问题就变成两个全是数字的字符串相加

        char[] c1 = i1.toCharArray();
        char[] c2 = i2.toCharArray();
        int length1 = c1.length;
        int length2 = c2.length;
        if (length1 >= length2) {

        } else {
            char[] t = c1;
            c1 = c2;
            c2 = t;
            length1 = c1.length;
            length2 = c2.length;
        }
        //c1长
        ListNode ok=null;
        int pre = 0;
        int index=1;
        while (index <= length2) {
            int a1 = c1[length1-index] - '0';
            int a2 = c2[length2-index] - '0';
            int sum = a1 + a2 + pre;
            ListNode tt=new ListNode(sum%10);
            pre = sum / 10;
            tt.next = ok;
            ok = tt;
            index++;
        }

        for (int i =length1- length2-1; i >=0; i--) {
            int a2 = c1[i] - '0';
            int sum =  a2 + pre;
            ListNode tt=new ListNode(sum%10);
            pre = sum / 10;
            tt.next = ok;
            ok = tt;
        }
        if (pre != 0) {
            ListNode tt = new ListNode(pre);
            tt.next = ok;
            ok = tt;
        }

        return ok;
    }

    private static String  toString(ListNode node) {
        ListNode temp = node;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.val);
            temp = temp.next;
        }
       return sb.toString();
    }

     public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
