package com.go2going.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 这题的难点在于数据规模很大，所有n^2的算法都不行
 * 所以可以绕过这个，union其公因数，因为公因数的数量是小于2sqrt(n)
 */
public class LeetCode_952 {

    /**
     * 这种方式超时
     * @param A
     * @return
     */
    public int largestComponentSize(int[] A) {
        long l = System.currentTimeMillis();
        int length = A.length;

        Map<Integer, List<Integer>> graph = new HashMap<>(length);

        //初始化graph
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (GCD(A[i], A[j]) != 1) {
                    List<Integer> integers = graph.getOrDefault(A[i],new ArrayList<>());
                    integers.add(A[j]);
                    graph.put(A[i], integers);
                    List<Integer> temp = graph.getOrDefault(A[j],new ArrayList<>());
                    temp.add(A[i]);
                    graph.put(A[j], temp);
                }
            }
        }

        Set<Integer> temp = new HashSet<>();
        int ans = 0;

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (temp.contains(entry.getKey())) {
                continue;
            }
            int sum = 1;
            temp.add(entry.getKey());
            Queue<Integer> q = new ArrayDeque<>();
            q.addAll(entry.getValue());
            while (!q.isEmpty()) {
                Integer poll = q.poll();
                if (!temp.contains(poll)) {
                    sum++;
                    temp.add(poll);
                    List<Integer> c = graph.get(poll);
                    for (Integer integer : c) {
                        if (!temp.contains(integer))
                            q.add(integer);
                    }
                }
            }
            if (sum > ans) {
                ans = sum;

            }
        }
        System.out.println(System.currentTimeMillis()-l);
        return ans;

    }



    private int find(int[][] set, int num) {
        while (set[num][0] != num) {
            num = set[num][0];
        }

        return num;
    }


    /**
     * union find 依然是n^2,超时，但是比第一种快了3倍
     * @param A
     * @return
     */
    public int largestComponentSize2(int[] A) {
        long l = System.currentTimeMillis();
        int length = A.length;

        int[][] unionSet = new int[100001][3];
        for (int i = 0; i < 100001; i++) {
            unionSet[i][0] = i;
            unionSet[i][1] = 1;//连接的点个数
            unionSet[i][2] = 1;//rank
        }

        int ans = 0;
        //初始化graph
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (GCD(A[i], A[j]) != 1) {
                    int x = find(unionSet, A[i]);
                    int y = find(unionSet, A[j]);
                    if (x != y) {
                        if (unionSet[y][2] > unionSet[x][2]) {
                            unionSet[x][0] = y;
                        } else if (unionSet[y][2] < unionSet[x][2]) {
                            unionSet[y][0] = x;
                        } else {
                            unionSet[x][0] = y;
                            unionSet[y][2] ++;
                        }
                        int h = unionSet[y][1] + unionSet[x][1];
                        unionSet[y][1] = h;
                        unionSet[x][1] = h;
                        ans = Math.max(ans, h);
                    }
                }
            }
        }
        System.out.println(System.currentTimeMillis()-l);


        return ans;

    }


    private int find(int[] set, int num) {
        while (set[num] != num) {
            num = set[num];
        }

        return num;
    }

    private void union(int[][] unionSet, int x, int y) {
        x = find(unionSet, x);
        y = find(unionSet, y);
        if (unionSet[y][1] > unionSet[x][1]) {
            unionSet[x][0] = y;
        } else if (unionSet[y][1] < unionSet[x][1]) {
            unionSet[y][0] = x;
        } else {
            unionSet[x][0] = y;
            unionSet[y][1] ++;
        }
    }

    /**
     * huahua 326ms
     * @param A
     * @return
     */
    public int largestComponentSize3(int[] A) {
        long l = System.currentTimeMillis();
        int length = 0;

        for (int i : A) {
            length = Math.max(length, i);
        }

        int[][] unionSet = new int[length+1][2];
        for (int i = 0; i < length; i++) {
            unionSet[i][0] = i;
            unionSet[i][1] = 1;//rank
        }

        for (int a : A) {
            //找到其所有公因数
            int t = (int) Math.sqrt(a);
            for (int k = 2; k <= t; k++) {
                if (a % k == 0) {
                    union(unionSet, a, k);
                    union(unionSet, a, a / k);
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int a : A) {
            int i1 = find(unionSet, a);
            Integer orDefault = map.getOrDefault(i1, 0);
            orDefault++;
            map.put(i1, orDefault);
            ans = Math.max(ans, orDefault);
        }
        System.out.println(System.currentTimeMillis()-l);


        return ans;

    }

    /**
     * wiki
     * @param a
     * @param b
     * @return
     */
    private int GCD(int a, int b) {
        if(b==0) return a;
        return a % b == 0 ? b : GCD(b, a % b);
    }


    public static void main(String[] args) {
        LeetCode_952 leetCode_952=new LeetCode_952();
        System.out.println(leetCode_952.largestComponentSize3(new int[]{4,6,15,35}));
    }
}
