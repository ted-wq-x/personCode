package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/10/15 19:20
 */
public class Main {
    public static void main(String[] args) {
        char[] cs = "azAz".toCharArray();

        String a = "A";
        char ca = 'A';

        System.out.println((char)65);
        System.out.println(getUnicode("azAZ"));
    }

    public static String getUnicode(String str) {
        char[] cs = str.toCharArray();
        String result = "";
        for (char c : cs) {
            String s = Integer.toHexString(c);
            if (s.length() == 2) {
                s = "\\u00" + s;
            } else {
                s = "\\u" + s;
            }
            result += s;
        }
        return result;
    }




    public int longestUnivaluePath(TreeNode root) {
        int[] res=new int[1];

        if(root!=null){
            test(root,res);
        }
        return res[0];
    }

      public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public int test(TreeNode root,int[] res){
        int l=root.left!=null?test(root.left,res):0;
        int r=root.right!=null?test(root.right,res):0;
        int left=root.left!=null&&root.left.val==root.val?l+1:0;
        int right=root.right!=null&&root.right.val==root.val?r+1:0;
        res[0] = Math.max(res[0],left+right)  ;
        return   Math.max(left,right)    ;
    }
}
