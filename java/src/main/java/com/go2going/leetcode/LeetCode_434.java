package com.go2going.leetcode;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_434<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/30 0030 10:56
 */
public class LeetCode_434 {
    public int countSegments(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++)
            //i==0 防止出界，且第一个单词也+1
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
                res++;
        return res;
    }
}
