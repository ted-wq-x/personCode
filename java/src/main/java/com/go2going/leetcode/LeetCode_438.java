package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_438<br>
 * 描述：好难，很难理解,看不懂
 *
 * @author wangqiang
 * 创建时间：  2017/12/5 0005 20:29
 */
public class LeetCode_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash

        //将字母放入数组，>0
        for (char c : p.toCharArray()) {
            hash[c]++;
        }

        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //当》=1时，说明还缺少p中的字母，count记录还需要的字母个数
            //如果在p中不存在的字母而在s中存在的，在数组中的值就是负数
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //移动窗口，在right没有达到窗口大小时，不会进入该方法，一旦达到窗口大小，则大小不会改变，也就是right-left都等于p.length()
            //
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }


}
