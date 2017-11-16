package com.go2going.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_202<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/16 0016 10:44
 */
public class LeetCode_202 {
    /**
     * 问题在于循环的出现,48%,ArrayList和HashSet差不多
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        while (true) {
            int temp = 0;
            while (n != 0) {
                int r = n % 10;
                temp += r*r;
                n /= 10;
            }
            if (temp == 1) {
                return true;
            }
            if (!inLoop.add(temp)) {
                return false;
            }
            n = temp;
        }
    }

}
