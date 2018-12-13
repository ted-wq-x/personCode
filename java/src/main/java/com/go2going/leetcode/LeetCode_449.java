package com.go2going.leetcode;

import java.math.BigInteger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.LinkedList;

import static com.go2going.leetcode.Helper.TreeNode;

public class LeetCode_449 {
    /**
     * Definition for a binary tree node.
     */
   /* public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }*/

    public static void main(String[] args) {
        LeetCode_449 leetCode_449 = new LeetCode_449();

        Codec2 codec = leetCode_449.new Codec2();
        String serialize = codec.serialize(Helper.stringToTreeNode("[2,1]"));
        // System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);

        System.out.println(deserialize);
    }

    /**
     * 没有利用到bst的性质，超时了
     */
    public class Codec {

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            LinkedList<TreeNode> cache = new LinkedList<>();
            cache.add(root);
            while (!cache.isEmpty()) {
                int size = cache.size();
                boolean goOn = false;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = cache.poll();
                    if (poll != null) {
                        sb.append(poll.val);
                        sb.append("|");
                        if (poll.left != null || poll.right != null) {
                            goOn = true;
                        }
                        cache.addLast(poll.left);
                        cache.addLast(poll.right);
                    } else {
                        sb.append("|");
                        cache.addLast(null);
                        cache.addLast(null);
                    }

                }
                if (!goOn) {
                    break;
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }
            String[] split = data.split("\\|");
            String s1 = split[0];
            if (s1.equals("")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(s1));

            LinkedList<TreeNode> cache = new LinkedList<>();
            cache.add(root);

            int count = 0;
            TreeNode cur = root;
            for (int i = 1; i < split.length; i++) {

                String s = split[i];
                TreeNode curNode = null;
                if (!s.equals("")) {
                    curNode = new TreeNode(Integer.parseInt(s));
                }
                if (count % 2 == 0) {
                    cur = cache.poll();
                    if (cur != null) {
                        cur.left = curNode;
                    }
                } else {
                    if (cur != null) {
                        cur.right = curNode;
                    }
                }
                count++;
                cache.addLast(curNode);

            }


            return root;

        }
    }

    /**
     * https://www.youtube.com/watch?v=GDqVCQcmxgU 2ms
     */
    public class Codec2 {

        /**
         * pre-order
         *
         * @param root
         * @return
         */
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            pre_order(sb, root);
            return sb.toString();
        }

        private void pre_order(StringBuilder sb, TreeNode root) {
            if (root == null) {
                return;
            }
            sb.append((char) root.val);
            pre_order(sb, root.left);
            pre_order(sb, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            char[] chars = data.toCharArray();
            return go(chars, 0, chars.length - 1);
        }

        /**
         * @param data
         * @param start include
         * @param end   include
         * @return
         */
        private TreeNode go(char[] data, int start, int end) {
            if (start > end) {
                return null;
            }
            TreeNode root = new TreeNode(data[start]);
            for (int i = start + 1; i <= end; i++) {
                if (data[i] > data[start]) {
                    root.left = go(data, start + 1, i - 1);
                    root.right = go(data, i, end);
                    break;
                }

                if (i == end) {
                    root.left = go(data, start + 1, i);
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
