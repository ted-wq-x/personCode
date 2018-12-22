package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.go2going.leetcode.Helper.TreeNode;

public class LeetCode_513 {
    /**
     * 10ms
     * @param root
     * @return
     */
    public int findBottomLeftValue2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> ans=new ArrayList<>();
        while (true) {
            int size = queue.size();
            boolean isLast = true;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.pop();
                ans.add(poll);
                if (poll.left != null) {
                    isLast = false;
                    queue.addLast(poll.left);
                }
                if (poll.right != null) {
                    isLast = false;

                    queue.addLast(poll.right);
                }
            }
            if (isLast) {
                break;
            } else {
                ans.clear();
            }
        }

        return ans.get(0).val;
    }

    int h = -1;
    int val = -1;

    /**
     * 3ms
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        deepGo(root,0);
        return val;
    }

    private void deepGo(TreeNode root,int h) {
        if (root == null) {
            return;
        }
        if (h > this.h) {
            val = root.val;
            this.h = h;
        }
        deepGo(root.left, h + 1);
        deepGo(root.right,h+1);
    }
    public static void main(String[] args) {
        LeetCode_513 leetCode_513=new LeetCode_513();
        System.out.println(leetCode_513.findBottomLeftValue(Helper.stringToTreeNode("[1,2,3,4,null,5,6,null,null,7]")));
    }
}
