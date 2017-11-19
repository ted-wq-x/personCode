package com.go2going.leetcode;

/**
 * Prefix Tree
 * 前缀树，字典树
 *
 * 每个节点记录字符和判断是否有以该单词结尾的
 * @author BlueT
 * 2017/11/19 0:06
 */
public class LeetCode_208 {


    class Trie {


        private TrieNode root;


        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode(' ');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {

            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    ws.children[c - 'a'] = new TrieNode(c);
                }
                ws = ws.children[c - 'a'];
            }

            ws.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode ws = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    return false;
                }
                ws = ws.children[c - 'a'];
            }

            return ws.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode ws = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (ws.children[c - 'a'] == null) {
                    return false;
                }
                ws = ws.children[c - 'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        TrieNode trieNode = new TrieNode('A');
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}


class TrieNode{

    //值
    public char val;

    //26个字符
    public TrieNode[] children = new TrieNode[26];

    //是否为单词的结尾
    public boolean isWord = false;

    public TrieNode() {
    }

    public TrieNode(char val) {
        this.val = val;
    }
}
