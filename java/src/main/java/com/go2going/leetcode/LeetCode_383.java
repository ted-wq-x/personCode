package com.go2going.leetcode;

/**
 * @author BlueT
 * 2017/11/4 17:51
 */
public class LeetCode_383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        char[] magazineChar = magazine.toCharArray();
        char[] ransomNoteChar = ransomNote.toCharArray();

        int length = magazine.length();

        int[] ints = new int[26];
        for (int i = 0; i < length; i++) {
            ints[magazineChar[i] - 'a']++;
        }

        for (int i = 0; i < ransomNoteChar.length; i++) {
            int i1 = ransomNoteChar[i] - 'a';
            if (ints[i1] == 0) {
                return false;
            }
            ints[i1]--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println((int)'a');
        System.out.println((int)'z');
    }
}
