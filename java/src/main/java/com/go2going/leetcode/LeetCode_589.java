package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * easy
 * @author BlueT
 * 2018/7/14 23:11
 */
public class LeetCode_589 {

    /**
     * recursive
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> ans=new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        for (Node child : root.children) {
            List<Integer> preorder = preorder(child);
            if (preorder.size() != 0) {
                ans.addAll(preorder);
            }
        }

        return ans;
    }

    /**
     * iterative
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> ans=new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> temp=new Stack<>();
        temp.push(root);
        while (!temp.empty()) {
            Node pop = temp.pop();
            ans.add(pop.val);
            List<Node> children = pop.children;
            for (int i = children.size()-1; i>=0; i--) {
                temp.push(children.get(i));
            }
        }



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
