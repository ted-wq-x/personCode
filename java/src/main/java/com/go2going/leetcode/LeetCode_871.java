package com.go2going.leetcode;


import java.util.*;

public class LeetCode_871 {
    Comparator<Integer> integerComparator = (o1, o2) -> o2 - o1;
    /**
     * 汽车每公里1升油
     * @param target 距离起点的距离
     * @param startFuel 开始时油的数量
     * @param stations stations[i][j] i:加油站,s[i][0]:从start到当前加油站的距离，s[i][1]:加油站还有的油
     * @return 最少停车加油的次数
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int stationNum = stations.length;

        int stopCount = 0,i=0;

        //21ms
        List<Integer> list=new ArrayList<>(stationNum);
        //52ms
        // PriorityQueue<Integer> queue=new PriorityQueue<Integer>((x, y) -> (x < y) ? 1 : ((x == y) ? 0 : -1));

        boolean sort = false;
        while (true) {

            if (startFuel >= target) {
                return stopCount;
            }
            //将当前汽油能够走的所有加油站放到队列中
            while (i < stationNum && startFuel >= stations[i][0]) {
                // queue.add(stations[i++][1]);
                list.add(stations[i++][1]);
                sort = true;
            }

            // 到这也就是需要加油了
            if (list.isEmpty()) {
                break;
            }
            //加油，尽可能加多的，减少加油次数
            stopCount++;
            if (sort) {
                list.sort(integerComparator);
                sort = false;
            }
            startFuel += list.remove(0);
        }


        return -1;
    }


    public static void main(String[] args) {

        LeetCode_871 leetCode_871=new LeetCode_871();

        int i = leetCode_871.minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}});
        System.out.println(i);
    }
}
