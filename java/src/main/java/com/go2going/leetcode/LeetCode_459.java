package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_459<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/29 0029 19:42
 */
public class LeetCode_459 {


    /**
     * 422ms->20ms,就加了一句判断，我曹
     * 暴力破解
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern1(String s) {
        boolean is = false;
        int length = s.length();
        for (int i = 1; i <= length / 2; i++) {
            //很关键
            if (length % i != 0) {
                continue;
            }
            String substring = s.substring(0, i);
            for (int j = i; j < length; j += i) {
                if (j + i > length) {
                    is = false;
                    break;
                }
                if (!substring.equals(s.substring(j, j + i))) {
                    is = false;
                    break;
                }
                is = true;
            }
            if (is) {
                return true;
            }
        }
        return false;
    }

}
