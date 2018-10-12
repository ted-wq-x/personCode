package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) {
        LeetCode_56 leetCode_56=new LeetCode_56();
        List<Interval> merge = leetCode_56.merge2(new ArrayList<Interval>() {
            {
                add(new Interval(20, 30));
                add(new Interval(5, 7));
                add(new Interval(3, 10));
                add(new Interval(25, 33));
                add(new Interval(2, 6));
            }
        });
        System.out.println(Arrays.toString(merge.toArray()));
    }

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


    /**
     * 提交答案中的最优解
     * @param intervals
     * @return
     */
    public List<Interval> merge2(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i = 1; i <= n; i++){
            // 排序之后的起始点可能会对应不上，但是在遍历的时候会将这种影响消除
            // 如果当前的开始点小于前一个区间的结束，那么这两个区间就是重合的，所以可以将当前区间的开始更改为前一个区间的开始
            // 注意边界：n是数组的长度，当i==n的时候就越界了
            if(i != n && start[i] <= end[i - 1]){
                start[i] = start[i - 1];
            }else{
                // 如果当前区间的开始大于前一个区间的结束，说明两个区间之间没有交集，那就就可以将前一个区间放到list中
                list.add(new Interval(start[i - 1], end[i - 1]));
            }
        }
        return list;
    }

     static class Interval {
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

         @Override
         public String toString() {
             return start+","+end;
         }
     }
}
