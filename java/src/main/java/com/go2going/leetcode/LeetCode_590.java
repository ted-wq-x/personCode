package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * easy
 *
 * @author BlueT
 * 2018/7/14 22:56
 */
public class LeetCode_590 {

    /**
     * recursive
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {

            List<Node> children = root.children;

            for (Node child : children) {
                List<Integer> postorder = postorder(child);
                if (postorder.size() != 0) {
                    ans.addAll(postorder);
                }
            }
            ans.add(root.val);
        }
        return ans;
    }

    /**
     * iterative
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> temp=new Stack<>();
        temp.push(root);
        while (!temp.empty()) {
            Node pop = temp.pop();
            ans.add(pop.val);
            for (Node child : pop.children) {
                temp.push(child);
            }
        }
        Collections.reverse(ans);



        return ans;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
