package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static com.go2going.leetcode.Helper.TreeNode;

public class LeetCode_655 {
    public static void main(String[] args) {
        LeetCode_655 leetCode_655=new LeetCode_655();

        List<List<String>> lists = leetCode_655.printTree2(Helper.stringToTreeNode("[1,2,5,3,null,null,null,4]"));
        // List<List<String>> lists = leetCode_655.printTree2(Helper.stringToTreeNode("[1,2]"));
        lists.forEach(strings -> {
            System.out.println(Arrays.toString(strings.toArray()));
        });
    }

    /**
     * 很多地方值得优化5ms
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }


        LinkedList<TreeNode> stack=new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<String> temp=new ArrayList<>(size);
            boolean isOk = true;
            for (int i = 0; i < size; i++) {
                TreeNode pop = stack.pop();
                if (pop == null) {
                    temp.add("") ;
                    stack.addLast(null);
                    stack.addLast(null);
                } else {
                    temp.add(pop.val+"");
                    isOk = false;
                    stack.addLast(pop.left);
                    stack.addLast(pop.right);
                }
            }


            if (isOk) {
                break;
            }
            ans.add(temp);
        }

        int size = ans.size();

        int eleSize = 1 << (size - 1);
        int langSize = 2 * eleSize - 1;

       boolean[] index=new boolean[langSize];
        for (int i = 0; i < langSize; i++) {
            if (i % 2 == 0) {
                index[i]=true;
            }
        }

        for (int i = size-1; i >=0; i--) {
            Object[] objects = ans.get(i).toArray();
            int m = 0;
            List<String> new_temp=new ArrayList<>(langSize);
            int pre=-1;
            for (int y = 0; y < langSize; y++) {
                if (index[y]) {
                    if (pre == -1) {
                        pre = y;
                    } else {
                        index[(pre + y) / 2] = true;
                        pre = -1;
                    }
                    index[y]=false;
                    new_temp.add((String) objects[m++]);
                } else {
                    new_temp.add("");
                }
            }
            ans.set(i,new_temp);
        }



        return ans;


    }


    /**
     * 这个代码要好理解很多 5ms
     * @param root
     * @return
     */
    public List<List<String>> printTree2(TreeNode root) {
        List<List<String>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int height = getHeight(root);
        int langSize = (1 << height) - 1;
        String[][] ts=new String[height][langSize];


        for (String[] t : ts) {
            Arrays.fill(t, "");
        }
        fillIt(ts, 0, 0, langSize-1, root);

        for (String[] t : ts) {
            ans.add(new ArrayList<>(Arrays.asList(t)));
        }

        return ans;
    }

    private void fillIt(String[][] ts, int height, int start,int end,TreeNode root) {
        if (root == null) {
            return;
        }
        int mid = (start + end) / 2;
        ts[height][mid] = String.valueOf(root.val);
        fillIt(ts, height+1, start, mid-1, root.left);
        fillIt(ts, height+1, mid+1, end, root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    // public static class TreeNode {
    //     int val;
    //     TreeNode left;
    //     TreeNode right;
    //
    //     TreeNode(int x) {
    //         val = x;
    //     }
    // }
}
