package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_93<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/19 0019 10:01
 */
public class LeetCode_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder ip = new StringBuilder();

        int length = s.length();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                for (int k = 1; k < 4; k++) {
                    for (int l = 1; l < 4; l++) {
                        if (i + j + k + l != length) {
                            continue;
                        }

                        int q1 = Integer.parseInt(s.substring(0, i));
                        if (q1 <= 255) {
                            int q2 = Integer.parseInt(s.substring(i, i + j));
                            if (q2 <= 255) {
                                int q3 = Integer.parseInt(s.substring(i + j, i + j + k));
                                if (q3 <= 255) {
                                    int q4 = Integer.parseInt(s.substring(i + j + k));
                                    if (q4 <= 255) {
                                        ip.append(q1).append('.').append(q2).append('.')
                                                .append(q3).append('.')
                                                .append(q4);
                                        //去除数字前面有0的情况，如025，变为int为25，但是不符合条件
                                        if (ip.length() == length + 3) res.add(ip.toString());
                                        ip = new StringBuilder();
                                        //                                        ip.delete(0, ip.length());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }


}
