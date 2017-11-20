package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_447<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/11/20 0020 10:29
 */
public class LeetCode_447 {
    public int numberOfBoomerangs(int[][] points) {

        int sum = 0;
        //key=距离，value=个数
        Map<Integer, Integer> map = new HashMap<>();

        //中间点
        for (int i = 0; i < points.length; i++) {

            for (int j = 0; j < points.length; j++) {
                if(i == j)
                    continue;
                int[] p1 = points[i];
                int[] p2 = points[j];
                int dx = p1[0] - p2[0];
                int dy = p1[1] - p2[1];
                int dis = dx * dx + dy * dy;
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }

            for (Integer val : map.values()) {
                //考虑到顺序不同，和概率是相同的
                sum += val * (val-1);
            }

            map.clear();

        }

        return sum;


    }



}
