package com.go2going.leetcode;
import java.util.LinkedList;

import static com.go2going.leetcode.Helper.TreeNode;

public class LeetCode_958 {
    public boolean isCompleteTree(TreeNode root) {
        int max = findDeep(root);
        LinkedList<TreeNode> stack=new LinkedList<>();
        stack.add(root);
        int index = 1;
        while (index<max) {
            int size = stack.size();
            if (size != 1 << (index-1)) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pop();
                if (index != max - 1) {
                    if (pop.left == null||pop.right==null) {
                        return false;
                    }
                }

                stack.addLast(pop.left);
                stack.addLast(pop.right);
            }
            index++;
        }
        boolean findNull=false;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (!findNull) {
                if (pop == null) {
                    findNull=true;
                }
            }else {
                if (pop != null) {
                    return false;
                }
            }

        }

        return true;
    }

    private int findDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(findDeep(root.left), findDeep(root.right));
    }
}
