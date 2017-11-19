package com.go2going.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author BlueT
 * 2017/11/18 22:43
 */
public class LeetCode_720 {

    /**
     * brute force暴力的方式104ms,使用排序的方式
     * @param words
     * @return
     */
    public static String longestWord1(String[] words) {


        Arrays.sort(words, (o1, o2) -> {
            int i = o2.length() - o1.length();

            //长度相等实现字典排序
            if (i == 0) {
                return o1.compareTo(o2);
            } else {
                return i;
            }
        });
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);

        for (String word : words) {
            int j = word.length() - 1;
            for (; j >= 0; j--) {
                if (!set.contains(word.substring(0, j))) {
                    break;
                }
            }
            if (j == 0) {
                return word;
            }
        }

        return null;
    }

    /**
     * 直接查找 49ms->21ms ,将判断移动到最前面
     * @param words
     * @return
     */
    public static String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        String res = "";

        for (String word : words) {
            int resLength = res.length();
            int length = word.length();
            //剪纸
            if (length < resLength||(length==resLength&&word.compareTo(res)>0)) {
                continue;
            }
            int j = length - 1;

            for (; j >= 0; j--) {
                if (!set.contains(word.substring(0, j))) {
                    break;
                }
            }
            //判断长度和字段顺序，移动到上面了
            if (j == 0) {
                res= word;
            }
        }
        return res;
    }

    class Tree{
        private TrieNode root = new TrieNode();

        /**
         * 插入
         * @param word
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
         * 判断单词的前缀是否都在树当中
         * @param res
         * @return
         */
        public boolean hasAllPrefix(String res) {
            TrieNode node = root;
            for (int i = 0; i < res.length()-1; i++) {
                TrieNode i1 = node.children[res.charAt(i) - 'a'];
                if (i1 == null ||!i1.isWord) {
                    return false;
                }
                node = i1;
            }

            return true;
        }

    }

    /**
     * 使用前缀树，参考208,23ms
     * @param words
     * @return
     */
    public String longestWord2(String[] words) {
        Tree tree = new Tree();
        for (String word : words) {
            tree.insert(word);
        }

        int max = 0;
        String w = "";
        for (String word : words) {
            if (tree.hasAllPrefix(word)) {
                int length = word.length();
                //要的是字典顺序小的
                if (length > max || (length == w.length() && word.compareTo(w) < 0)) {
                    max = length;
                    w = word;
                }
            }

        }
        return w;

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


    public static void main(String[] args) {
        String[] str = {"k", "lg", "it", "oidd", "oid", "oiddm", "kfk", "y", "mw", "kf", "l", "o", "mwaqz", "oi", "ych", "m", "mwa"};
        System.out.println(longestWord(str));

    }


}
