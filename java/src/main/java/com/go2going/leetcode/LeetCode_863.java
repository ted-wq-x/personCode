package com.go2going.leetcode;

import com.go2going.leetcode.Helper.TreeNode;

import java.util.*;

import static com.go2going.leetcode.Helper.stringToTreeNode;

/**
 * https://www.youtube.com/watch?v=o1siL8eKCos
 * @author BlueT
 * 2018/7/15 11:10
 */
public class LeetCode_863 {

    /**
     * 1. graph + BFS 无向图
     * 2. recursive
     *
     *
     *
     * @param root
     * @param target
     * @param K
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> ans = new ArrayList<>();
        if (K == 0) {
            ans.add(target.val);
            return ans;
        }
        buildGraph(null, root);


//        dfs(K, null,ans,target);

        Set<TreeNode> seen = new HashSet<>();

        Deque<TreeNode> temp = new ArrayDeque<>();
        temp.push(target);
        while (temp.size()!=0) {

            int size = temp.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = temp.pop();
                seen.add(pop);
                List<TreeNode> treeNodes = map.get(pop);
                for (TreeNode treeNode : treeNodes) {
                    if (seen.contains(treeNode)) {
                        continue;
                    }
                    temp.addLast(treeNode);
                }

            }

            if (--K <= 0) {
                for (TreeNode treeNode : temp) {
                    ans.add(treeNode.val);
                }
                break;
            }
        }


        return ans;
    }

  private static   List<Integer> ans = new ArrayList<>();
    /**
     * 方法二递归
     * @param root
     * @param target
     * @param K
     * @return
     */
    public List<Integer> distanceK2(TreeNode root, TreeNode target, int K) {

        //clear的原因是有使用的类变量
        ans.clear();
        dis(root, target, K);

        return ans;
    }

    /**
     * 一共就2中情况，看下视频理解下
     *
     * @param root
     * @param target
     * @param K
     * @return target到root的距离
     */
    private static int dis(TreeNode root, TreeNode target, int K) {
        if (root == null) {
            return -1;
        }
//        在子树中查找距离为k的节点
        if (target == root) {
            collect(root, K);
            return 0;
        }

        int l = dis(root.left, target, K);
        int r = dis(root.right, target, K);
//        target在左子树中
        if (l >= 0) {
            if (l == K - 1) {
                ans.add(root.val);
            }
//            -2的原因是l是从root.left计算的，而在left到right的距离为2
            collect(root.right, K - 2 - l);
            return l + 1;
        }
//        target在右子树中
        if (r >= 0) {
            if (r == K - 1) {
                ans.add(root.val);
            }
            collect(root.left, K - 2 - r);
            return r + 1;
        }
        return -1;
    }

    private static void collect(TreeNode node, int d) {
        if (node == null || d < 0) {
            return;
        }
        if (d == 0) {
            ans.add(node.val);
        }

        collect(node.left, d - 1);
        collect(node.right, d - 1);
    }


    /**
     * 4ms
     * 在无向图中找到距离为k的点
     * @param k
     * @param preNode 排除原先的查找路径
     * @param ans
     * @param start
     */
    private static void dfs(int k, TreeNode preNode, List<Integer> ans, TreeNode start) {
        List<TreeNode> nodes = map.get(start);

        if (k == 0) {
            ans.add(start.val);
            return;
        }
        for (TreeNode treeNode : nodes) {
            if (treeNode == preNode) {
                continue;
            }
            dfs(k-1,start,ans,treeNode);
        }
    }


    //领近节点
    private static Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    private static void buildGraph(TreeNode parent, TreeNode child) {
        if (parent != null) {
            List<TreeNode> nodes = map.get(parent);
            if (nodes == null) {
                nodes = new ArrayList<>();
            }
            nodes.add(child);
            map.put(parent, nodes);

            nodes = map.get(child);
            if (nodes == null) {
                nodes = new ArrayList<>();
            }
            nodes.add(parent);
            map.put(child, nodes);
        }else {
//            特殊情况
            if (child.left == null && child.right == null) {
                map.put(child, new ArrayList<>());
                return;
            }
        }

        if (child.left != null) {
            buildGraph(child,child.left);
        }

        if (child.right != null) {
            buildGraph(child,child.right);
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        LeetCode_863 leetCode_863=new LeetCode_863();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(treeNode);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.pop();
            if (temp == null) {
                continue;
            }
            if (temp.val == 5) {
                leetCode_863.distanceK(treeNode,temp , 2);
                break;
            }
            queue.push(temp.left);
            queue.push(temp.right);

        }


    }

}
