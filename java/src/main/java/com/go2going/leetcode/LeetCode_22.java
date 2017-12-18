package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BlueT
 * 2017/12/17 14:45
 */
public class LeetCode_22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1) {
            return list;
        }
        dfs(list, "", n, 0, 0);
        return list;
    }

    public void dfs(List<String> res, String temp, int n, int left, int right) {
        //注意是right，左边等于n时还少个右边
        if(right == n) {
            res.add(temp);
            return;
        }
        //左括号小于等于n，右括号《左括号
        if (left < n) dfs(res, temp+"(", n, left+1, right);
        if (right < left) dfs(res, temp+")", n, left, right+1);
    }
}
