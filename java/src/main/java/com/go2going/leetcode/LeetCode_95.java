package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_95<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/19 0019 10:48
 */
public class LeetCode_95 {

    /**
     * 构建所有的二叉搜索树，左节点<=根节点，右节点>=根节点
     * 这个题目的一个隐藏点在于1到n的任何bts的中序遍历都是1到n，这个很关键，也是牛逼
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();

        }

        return go(1, n);
    }

    private List<TreeNode> go(int start, int end) {
        List<TreeNode> res = new ArrayList<>();

        if (start > end) {
            res.add(null);
            return res;
        }

        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        //起始位置
        for (int i = start; i <= end; i++) {
            //下面两个，获取在这个范围内所有可能的，左右树，且l<=r,并且排除了已经使用的数字
            List<TreeNode> l = go(start, i - 1);
            List<TreeNode> r = go(i + 1, end);

            //进行节点组装
            for (TreeNode left : l) {
                for (TreeNode right : r) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }

        }

        return res;
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
