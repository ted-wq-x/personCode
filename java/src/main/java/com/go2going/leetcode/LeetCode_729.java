package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author BlueT
 * 2017/11/20 20:18
 */
public class LeetCode_729 {
    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(47, 50));
        System.out.println(calendar.book(33, 41));
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
class MyCalendar {

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendar() {

    }

    /**
     * 218ms
     * @param start
     * @param end
     * @return
     */
    public boolean book(int start, int end) {
        //自己列举出为false的情况
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (end > key && end < value) {
                return false;
            }
            if (start >= key && start < value) {
                return false;
            }

            if (end >= value && start < value) {
                return false;
            }
        }
        map.put(start, end);
        return true;
    }

    /**
     * 156ms，得分析具体情况
     * @param start
     * @param end
     * @return
     */
    public boolean book2(int start, int end) {
        Integer floorKey = map.floorKey(start);
        if (floorKey != null && map.get(floorKey) > start) return false;
        Integer ceilingKey = map.ceilingKey(start);//比最大值小
        if (ceilingKey != null && ceilingKey < end) return false;
        map.put(start, end);
        return true;
    }

    private List<Integer[]> list = new ArrayList<>();

    /**
     * 213ms
     * @param start
     * @param end
     * @return
     */
    public boolean book1(int start, int end) {
        //自己列举出为false的情况
        for (Integer[] integer : list) {
            Integer key = integer[0];
            Integer value = integer[1];
            if (Math.max(key, start) < Math.min(end, value)) {
                return false;
            }
        }
        list.add(new Integer[]{start, end});

        return true;
    }
}