package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

import static com.go2going.leetcode.Helper.TreeNode;
import static com.go2going.leetcode.Helper.stringToTreeNode;

public class LeetCode_971 {
    int index = 0;
    List<Integer> ans = new ArrayList<>();
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        boolean b = dfs(root, voyage);
        if (!b) {
            ans = new ArrayList<>();
            ans.add(-1);
        }
        return ans;
    }

    private boolean dfs(TreeNode root, int[] voyage  ) {
        if (root == null) {
            return true;
        }
        if (root.val != voyage[index++]) {
            return false;
        }
        if (root.left != null && root.left.val != voyage[index]) {
            ans.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        }
        return dfs(root.left, voyage) && dfs(root.right, voyage);
    }


    public static void main(String[] args) {
        Helper.TreeNode root=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(3);
        root.left = left;
        root.right= right;
        LeetCode_971 leetCode_971=new LeetCode_971();
        System.out.println(leetCode_971.flipMatchVoyage(stringToTreeNode("[1,2,3]"), new int[]{1, 3, 2}));


    }
}
