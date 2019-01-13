package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BlueT
 * 2018/11/10 9:39
 */
public class LeetCode_648 {
    public static void main(String[] args) {
        LeetCode_648 leetCode_648=new LeetCode_648();
        ArrayList<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String s = leetCode_648.replaceWords(dict, "the cattle was rattled by the battery");
        System.out.println(s);
    }

    /**
     * 字典树 26ms
     * @param dict
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dict, String sentence) {
        String[] words = sentence.split(" ");

        TireTree tireTree=new TireTree();

        for (String s : dict) {
            tireTree.insert(s);
        }

        for (int i = 0; i < words.length; i++) {
            String prefix = tireTree.getPrefix(words[i]);
            if (prefix != null) {
                words[i] = prefix;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }


    class TireTree {

        private class Node {

            private boolean isLeaf;
            private Node[] childs;
            public Node(){
                childs = new Node[26];
                isLeaf = false;
            }

        }

        private Node root;

        public TireTree() {
            this.root =new Node();
        }

        public void insert(String word) {
            insert(root, word);
        }

        private void insert(Node root, String word) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];

                int index = c - 'a';
                if (root.childs[index] == null) {
                    root.childs[index]=new Node();
                }


                if (i == chars.length - 1) {
                    root.childs[index].isLeaf=true;
                }

                root = root.childs[index];
            }

        }

        public String getPrefix(String word) {
            Node root = this.root;
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                Node child = root.childs[index];
                if (child == null) {
                    return null;
                }
                if (child.isLeaf) {
                    return word.substring(0, i + 1);
                }
                root = child;
            }
            return null;
        }
    }
}

