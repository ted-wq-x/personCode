package com.go2going.datastructue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Tree<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/24 0024 8:54
 */
public class Tree {
    //给定有序查找表array 二分查找给定的值data
    //查找成功返回下标 查找失败返回-1
    static int funBinSearch(int[] array, int data) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (data == array[mid]) {
                return mid;
            } else if (data < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 二叉树的节点
    public class TreeNode<E extends Comparable<E>> {

        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }

        //          a
        //        /   \
        //       b     c
        //     /   \
        //    d     f
        //     \   /
        //      e g
        // 前：abdefgc
        // 后：edgfbca
        // 中：debgfac

        ///////////////////////////////////////////////////////////////////////////
        // 前序遍历：根结点 -> 左子树 -> 右子树
        // 中序遍历：左子树 -> 根结点 -> 右子树
        // 后序遍历：左子树 -> 右子树 -> 根结点
        ///////////////////////////////////////////////////////////////////////////

        /**
         * 前序遍历
         *
         * @param root
         * @return
         */
        public List<E> preOrderTraversal(TreeNode<E> root) {
            List<E> result = new ArrayList<>();
            preOrderTraversal0(root, result);
            return result;
        }

        private void preOrderTraversal0(TreeNode<E> root, List<E> result) {
            if (root == null) {
                return;
            }
            result.add(root.element);
            preOrderTraversal0(root.left, result);
            preOrderTraversal0(root.right, result);
        }

        public List<E> preOrderTraversalWithoutRecursion(TreeNode<E> root) {
            List<E> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Stack<TreeNode<E>> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode<E> node = stack.pop();
                result.add(node.element);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return result;
        }


        /**
         * 层次遍历
         * @param root
         * @return
         */
        public List<E> levelTraversal(TreeNode<E> root) {
            List<E> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            LinkedList<TreeNode<E>> queue = new LinkedList<>();
            queue.addLast(root);

            while (!queue.isEmpty()) {
                TreeNode<E> node = queue.pollFirst();
                result.add(node.element);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            return result;
        }

        /**
         * 打印树结构
         * @param root
         */
        public void printTree(TreeNode<E> root) {

            if (root == null) {
                return ;
            }
            int height = getHeight(root);
            int langSize = (1 << height) - 1;
            String[][] ts=new String[height][langSize];


            for (String[] t : ts) {
                Arrays.fill(t, "");
            }
            fillIt(ts, 0, 0, langSize-1, root);

            for (String[] t : ts) {
                System.out.println(Arrays.toString(t));
            }

        }

        private void fillIt(String[][] ts, int height, int start,int end,TreeNode root) {
            if (root == null) {
                return;
            }
            int mid = (start + end) / 2;
            ts[height][mid] = String.valueOf(root.element);
            fillIt(ts, height+1, start, mid-1, root.left);
            fillIt(ts, height+1, mid+1, end, root.right);
        }

        private int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }


        /**
         * 后序遍历
         *
         * @param root
         * @return
         */
        public List<E> postOrderTraversal(TreeNode<E> root) {
            List<E> result = new ArrayList<>();
            postOrderTraversal0(root, result);
            return result;
        }

        private void postOrderTraversal0(TreeNode<E> root, List<E> result) {
            if (root == null) {
                return;
            }
            postOrderTraversal0(root.left, result);
            postOrderTraversal0(root.right, result);
            result.add(root.element);
        }

        /**
         * TODO
         * @param root
         * @return
         */
        public List<E> postOrderTraversalWithoutRecursion(TreeNode<E> root) {
            List<E> result = new ArrayList<>();
            if (root == null)
                return result;
            Stack<TreeNode<E>> stack = new Stack<>();
            TreeNode p = root;
            TreeNode last = null;
            while (p != null || !stack.isEmpty()) {
                if (p != null) {
                    stack.push(p);
                    p = p.left;
                } else {
                    TreeNode<E> peek = stack.peek();
                    if (peek.right != null && last != peek.right) {
                        p = peek.right;
                    } else {
                        peek = stack.pop();
                        result.add(peek.element);
                        last = peek;
                    }
                }
            }
            return result;
        }


        /**
         * 中序遍历
         *
         * @param root
         * @return
         */
        public List<E> inOrderTraversal(TreeNode<E> root) {
            List<E> result = new ArrayList<>();
            inOrderTraversal0(root, result);
            return result;
        }

        private void inOrderTraversal0(TreeNode<E> root, List<E> result) {
            if (root == null) {
                return;
            }
            inOrderTraversal0(root.left, result);
            result.add(root.element);
            inOrderTraversal0(root.right, result);
        }


        public List<E> inOrderTraversalWithoutRecursion(TreeNode<E> root) {
            List<E> result = new ArrayList<>();
            if (root == null)
                return result;
            Stack<TreeNode<E>> stack = new Stack<>();
            TreeNode<E> p = root;
            while (p != null || !stack.isEmpty()) {
                if (p != null) {
                    //
                    stack.push(p);
                    p = p.left;
                } else {
                    //p为null，表示左节点为null
                    p = stack.pop();//根节点
                    result.add(p.element);
                    p = p.right;
                }
            }
            return result;
        }
    }


}
