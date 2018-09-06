package com.go2going.leetcode;

import com.go2going.leetcode.Helper.TreeNode;

import java.util.Arrays;

public class LeetCode_889 {

    public static void main(String[] args) {
        LeetCode_889 leetCode_889 = new LeetCode_889();

        // leetCode_889.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]
        //         {4, 5, 2, 6, 7, 3, 1});
        leetCode_889.constructFromPrePost(new int[]{2, 1}, new int[]
                {1, 2});
    }

    /**
     * Tree
     * <br>
     * pre: root,(left),(right)<br>
     * in:  (left),root,(right)<br>
     * post:    (left),(right),root<br>
     * 上面是树遍历的三种方式，在遍历完的数组中值的排列顺序是上面的形式（注意括号，此时root就理解成根节点），也就是在pre和post的第一和最后一个一定是根节点<br>
     * 可以参考这个图（pic/tree.png）
     *
     * @param pre  pre和post中元素是一样的
     * @param post
     * @return
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int length = pre.length;
        if (length == 0) {
            return null;
        }
        // 问题的关键是确定left节点的长度
        TreeNode root = new TreeNode(pre[0]);
        if (length == 1) {
            return root;
        }

        int target = pre[1];
        for (int i = 0; i < length; i++) {
            if (post[i] == target) {
                //i+1 是左节点的长度
                // pre第一个节点排除，post最后一个节点排除
                root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, i + 2), Arrays.copyOf(post, i + 1));
                root.right = constructFromPrePost(Arrays.copyOfRange(pre, i + 2, length), Arrays.copyOfRange(post, i + 1, length - 1));
                break;
            }
        }


        return root;


    }

}
