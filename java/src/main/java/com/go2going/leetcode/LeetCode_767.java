package com.go2going.leetcode;

public class LeetCode_767 {

    /**
     * 思路挺好 https://leetcode.com/problems/reorganize-string/discuss/113432/Java-6ms-O(n)-no-sorting
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        //每个字符出现的次数
        int[] ints = new int[26];
        int maxIndex=0;
        for (char c : S.toCharArray()) {

            ints[c - 97]++;
            if (ints[c - 97] > ints[maxIndex]) {
                maxIndex = c - 97;
            }
        }
        //如果出现次数最多的字符数超过长度的一半
        int length = S.length();
        if (length < ints[maxIndex] * 2 - 1) {
            return "";
        }

        char[] chars = new char[length];

        //下面的思路是,间隔着方最长的，由于上面的判断肯定不会越界
        int index = 0;
        for (int i = 0; i < ints[maxIndex]; i++) {
            chars[index] = (char) (maxIndex + 97);
            index += 2;
        }
        //用完了最长的，计数变为0
        ints[maxIndex] = 0;

        //遍历所有未使用的字符，间隔着放
        for (int i = 0; i < 26; i++) {
            int count = ints[i];
            while (count > 0) {
                //到头了，从最左边重新开始
                if (index >= length) {
                    index = 1;
                }
                chars[index] = (char) (i + 97);
                count--;
                index += 2;
            }
        }


        return new String(chars);
    }

}
