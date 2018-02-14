package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_199<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/14 0014 10:33
 */
public class LeetCode_199 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new ArrayList<>();


    /**
     * 原有的思路是使用队列 保存每一层 的节点，然后取第一个就行（保存的时候从右往左依次保存）
     * https://leetcode.com/problems/binary-tree-right-side-view/discuss/56012/My-simple-accepted-solution(JAVA)
     * 直接使用index确保是在同一层级当中
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {

            return list;
        }


        go(root,0);

        return list;
    }


    private void go(TreeNode root,int index){
        if (root == null) {
            return;
        }

        //此处非常的巧妙，给个赞，画个图理解下
        if (list.size() == index) {
            list.add(root.val);
        }

        // 西安保存右边的节点
        go(root.right, index + 1);
        go(root.left, index + 1);

    }


}
