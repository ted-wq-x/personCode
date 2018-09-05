package com.go2going.leetcode;

import com.go2going.leetcode.Helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_894 {

    /**
     * 记忆化递归6ms，未记忆化11ms
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBT(int N) {


        List<TreeNode> ans = new ArrayList<>();
        //偶数个节点无法构成满二叉树
        if (N % 2 == 0) {
            return ans;
        }

        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }

        Map<Integer,List<TreeNode>> mem=new HashMap<>();

        //将所有的节点分为左右两个部分，这儿就是这个算法的关键
        for (int i = 1; i < N; i+=2) {
            List<TreeNode> leftNodes = mem.get(i);
            if (leftNodes == null) {
                leftNodes = allPossibleFBT(i);
                mem.put(i, leftNodes);
            }
            for (TreeNode l : leftNodes) {
                int index = N - i - 1;
                List<TreeNode> rightNodes = mem.get(index);
                if (rightNodes == null) {
                    rightNodes = allPossibleFBT(index);
                    mem.put(index, rightNodes);
                }
                for (TreeNode r : rightNodes) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }

            }
        }

        return ans;
    }
}
