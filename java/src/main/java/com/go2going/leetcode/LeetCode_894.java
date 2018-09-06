package com.go2going.leetcode;

import com.go2going.leetcode.Helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_894 {
    private Map<Integer, List<TreeNode>> cache = new HashMap<>();

    /**
     * 记忆化递归4ms，未记忆化11ms
     *
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBT(int N) {

        if (cache.get(N) != null) return cache.get(N);

        List<TreeNode> ans = new ArrayList<>();
        //偶数个节点无法构成满二叉树
        if (N % 2 == 0) {
            return ans;
        }

        if (N == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }


        //将所有的节点分为左右两个部分，这儿就是这个算法的关键
        for (int i = 1; i < N; i += 2) {
            for (TreeNode l : allPossibleFBT(i)) {
                for (TreeNode r : allPossibleFBT(N - i - 1)) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }

            }
        }
        cache.put(N, ans);
        return ans;
    }
}
