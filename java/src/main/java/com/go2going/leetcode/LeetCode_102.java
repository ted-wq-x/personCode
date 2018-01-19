package com.go2going.leetcode;

import java.util.*;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_102<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/19 0019 16:08
 */
public class LeetCode_102 {
    /**
     * 前序遍历，按照层级返回
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        go(root,0,res);

        return res;
    }

    /**
     * 使用index和list的size确认是否初始化了list
     * @param node
     * @param index
     * @param res
     */
    private void go(TreeNode node,int index,List<List<Integer>> res) {
        if(node==null) return;
        if (index == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(index).add(node.val);
        go(node.left,index+1,res);
        go(node.right,index+1,res);

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
