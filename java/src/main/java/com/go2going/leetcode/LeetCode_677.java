package com.go2going.leetcode;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * For the method insert, you'll be given a pair of (string, integer).
 * The string represents the key and the integer represents the value.
 * If the key already existed, then the original key-value pair will be overridden to the new one.
 * <p>
 * For the method sum, you'll be given a string representing the prefix,
 * and you need to return the sum of all the pairs' value whose key starts with the prefix.
 */
public class LeetCode_677 {
    public static void main(String[] args) {
        LeetCode_677 leetCode_677 = new LeetCode_677();

        MapSum obj = leetCode_677.new MapSum();
        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));
    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
    class MapSum2 {
        private Map<String, Integer> map;


        /**
         * Initialize your data structure here.
         */
        public MapSum2() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

            for (Map.Entry<String, Integer> entry : entrySet) {

                if (entry.getKey().startsWith(prefix)) {
                    sum += entry.getValue();
                }
            }
            return sum;
        }
    }

    /**
     * 使用树
     */
    class MapSum {

        TreeNode root;

        public MapSum() {
            root = new TreeNode();
        }

        public void insert(String key, int val) {
            TreeNode cur = root;
            for (char c : key.toCharArray()) {
                TreeNode treeNode = cur.childNode.get(c);
                if (treeNode == null) {
                    treeNode = new TreeNode();
                    cur.childNode.put(c, treeNode);
                }
                cur = treeNode;
            }

            //最后一个字符才放值
            cur.value = val;
            cur.isWord = true;
        }

        public int sum(String prefix) {
            TreeNode cur = root;
            // 1. 找到前缀
            for (char c : prefix.toCharArray()) {
                TreeNode treeNode = cur.childNode.get(c);
                if (treeNode == null) {
                    return 0;
                }
                cur = treeNode;
            }
            // 2.递归所有组合
            return dfs(cur);
        }

        private int dfs(TreeNode root) {
            int sum = 0;

            for (Character c : root.childNode.keySet()) {
                TreeNode node = root.childNode.get(c);
                sum += dfs(node);

            }
            if (root.isWord) {
                return sum + root.value;
            }
            return sum;
        }

        class TreeNode {
            Map<Character, TreeNode> childNode = new HashMap<>();
            int value = 0;
            //这个可有可无
            boolean isWord = false;
        }
    }

}
