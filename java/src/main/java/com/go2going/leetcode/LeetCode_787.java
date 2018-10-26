package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_787 {

    /**
     * 不断的优化，从70+ms到12ms
     * @param args
     */
    public static void main(String[] args) {
        LeetCode_787 leetCode_787 = new LeetCode_787();
        System.out.println(leetCode_787.findCheapestPrice2(15,
                new int[][]{{10,14,43},{1,12,62},{4,2,62},{14,10,49},{9,5,29},{13,7,53},{4,12,90},{14,9,38},{11,2,64},{2,13,92},{11,5,42},{10,1,89},{14,0,32},{9,4,81},{3,6,97},{7,13,35},{11,9,63},{5,7,82},{13,6,57},{4,5,100},{2,9,34},{11,13,1},{14,8,1},{12,10,42},{2,4,41},{0,6,55},{5,12,1},{13,3,67},{3,13,36},{3,12,73},{7,5,72},{5,6,100},{7,6,52},{4,7,43},{6,3,67},{3,1,66},{8,12,30},{8,3,42},{9,3,57},{12,6,31},{2,7,10},{14,4,91},{2,3,29},{8,9,29},{2,11,65},{3,8,49},{6,14,22},{4,6,38},{13,0,78},{1,10,97},{8,14,40},{7,9,3},{14,6,4},{4,8,75},{1,6,56}},
                1, 4, 10));
      /*  System.out.println(leetCode_787.findCheapestPrice2(17,
                new int[][]{{0, 12, 28}, {5, 6, 39}, {8, 6, 59}, {13, 15, 7}, {13, 12, 38}, {10, 12, 35}, {15, 3, 23}, {7, 11, 26}, {9, 4, 65}, {10, 2, 38}, {4, 7, 7}, {14, 15, 31}, {2, 12, 44}, {8, 10, 34}, {13, 6, 29}, {5, 14, 89}, {11, 16, 13}, {7, 3, 46}, {10, 15, 19}, {12, 4, 58}, {13, 16, 11}, {16, 4, 76}, {2, 0, 12}, {15, 0, 22}, {16, 12, 13}, {7, 1, 29}, {7, 14, 100}, {16, 1, 14}, {9, 6, 74}, {11, 1, 73}, {2, 11, 60}, {10, 11, 85}, {2, 5, 49}, {3, 4, 17}, {4, 9, 77}, {16, 3, 47}, {15, 6, 78}, {14, 1, 90}, {10, 5, 95}, {1, 11, 30}, {11, 0, 37}, {10, 4, 86}, {0, 8, 57}, {6, 14, 68}, {16, 8, 3}, {13, 0, 65}, {2, 13, 6}, {5, 13, 5}, {8, 11, 31}, {6, 10, 20}, {6, 2, 33}, {9, 1, 3}, {14, 9, 58}, {12, 3, 19}, {11, 2, 74}, {12, 14, 48}, {16, 11, 100}, {3, 12, 38}, {12, 13, 77}, {10, 9, 99}, {15, 13, 98}, {15, 12, 71}, {1, 4, 28}, {7, 0, 83}, {3, 5, 100}, {8, 9, 14}, {15, 11, 57}, {3, 6, 65}, {1, 3, 45}, {14, 7, 74}, {2, 10, 39}, {4, 8, 73}, {13, 5, 77}, {10, 0, 43}, {12, 9, 92}, {8, 2, 26}, {1, 7, 7}, {9, 12, 10}, {13, 11, 64}, {8, 13, 80}, {6, 12, 74}, {9, 7, 35}, {0, 15, 48}, {3, 7, 87}, {16, 9, 42}, {5, 16, 64}, {4, 5, 65}, {15, 14, 70}, {12, 0, 13}, {16, 14, 52}, {3, 10, 80}, {14, 11, 85}, {15, 2, 77}, {4, 11, 19}, {2, 7, 49}, {10, 7, 78}, {14, 6, 84}, {13, 7, 50}, {11, 6, 75}, {5, 10, 46}, {13, 8, 43}, {9, 10, 49}, {7, 12, 64}, {0, 10, 76}, {5, 9, 77}, {8, 3, 28}, {11, 9, 28}, {12, 16, 87}, {12, 6, 24}, {9, 15, 94}, {5, 7, 77}, {4, 10, 18}, {7, 2, 11}, {9, 5, 41}},
                // 13, 4, 13));*/
        // System.out.println(leetCode_787.findCheapestPrice2(10, new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}}, 6, 0, 7));
    }

    /**
     * DFS 26ms
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] start = new int[n][K + 1];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            List<int[]> orDefault = map.getOrDefault(flight[0], new ArrayList<>());
            orDefault.add(flight);
            map.put(flight[0], orDefault);
        }
        return go(start, map, src, dst, K);
    }


    private int go(int[][] start, Map<Integer, List<int[]>> map, int src, int dst, int K) {
        int sum = Integer.MAX_VALUE;
        if (start[src][K] != 0) {
            return start[src][K];
        }
        List<int[]> ffs = map.get(src);
        if (ffs != null) {
            for (int[] flight : ffs) {
                if (flight[1] == dst) {
                    if (flight[2] < sum) {
                        sum = flight[2];
                    }
                    if (K == 0) {
                        break;
                    }
                } else {
                    if (K != 0) {
                        int price = go(start, map, flight[1], dst, K - 1);
                        if (price != -1) {
                            int m = flight[2] + price;
                            if (m < sum) {
                                sum = m;
                            }
                        }
                    }
                }
            }
        }

        if (sum == Integer.MAX_VALUE) {
            for (int i = 0; i <= K; i++) {
                start[src][i] = -1;
            }
            return -1;
        } else {
            start[src][K] = sum;
            return sum;
        }
    }

    /**
     * BFS 12ms
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param K
     * @return
     */
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {

        int sum = Integer.MAX_VALUE;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(src);

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            List<int[]> orDefault = map.getOrDefault(flight[0], new ArrayList<>());
            orDefault.add(flight);
            map.put(flight[0], orDefault);
        }
        // key=暂时的dst，value=到这里最小的money
        // 还可以改进，适用数组
        Map<Integer, Integer> value = new HashMap<>();
        value.put(src, 0);

        while (!queue.isEmpty() && K >= 0) {
            int size = queue.size();
            Map<Integer, Integer> temp = new HashMap<>();
            for (int y = 0; y < size; y++) {
                Integer pop = queue.pop();
                List<int[]> ints = map.get(pop);
                if (ints == null) {
                    continue;
                }
                Integer sumMoney = value.remove(pop);
                if (sumMoney >= sum) {
                    continue;
                }
                for (int[] flight : ints) {
                    int tempSum = flight[2] + sumMoney;
                    if (flight[1] == dst) {
                        if (tempSum < sum) {
                            sum = tempSum;
                        }
                    } else {
                        Integer integer = temp.get(flight[1]);
                        if (integer == null) {
                            temp.put(flight[1], tempSum);
                        } else {
                            if (integer > tempSum) {
                                temp.put(flight[1], tempSum);
                            }
                        }
                    }
                }
            }
            queue.addAll(temp.keySet());
            value.putAll(temp);
            K--;
        }

        if (sum == Integer.MAX_VALUE) {
            return -1;
        } else {
            return sum;
        }
    }
}
