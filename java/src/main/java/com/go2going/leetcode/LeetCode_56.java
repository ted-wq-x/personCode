package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_56<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/1/2 0002 13:06
 */
public class LeetCode_56 {

    /**
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        int size = intervals.size();
        if (size <= 1) {
            return intervals;
        }

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {

                return o1.start - o2.start;
            }
        });

        list.add(intervals.get(0));
        for (int i = 1; i < size; i++) {
            Interval pre = list.get(list.size() - 1);
            Interval cur = intervals.get(i);
            if (pre.end >= cur.start) {
                pre.end = Math.max(cur.end, pre.end);
            } else {
                list.add(cur);
            }
        }

        return list;
    }


    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
