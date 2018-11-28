package com.go2going.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_947 {
    public static void main(String[] args) {
        LeetCode_947 leetCode_947 = new LeetCode_947();
        // System.out.println(leetCode_947.removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));
        // System.out.println(leetCode_947.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println(leetCode_947.removeStones(new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 3}, {2, 3}, {0, 2}}));
        System.out.println(leetCode_947.removeStones2(new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 3}, {2, 3}, {0, 2}}));
    }

    /**
     * 在二维坐标的整数坐标点上，有一些石头，如果一个石头和另外一个石头的横坐标或者纵坐标相等，那么认为他们是有链接的。
     * 我们每次取一个和别人有链接的石头，问最终能取得多少个石头
     * <p>
     * 硬解代码较难实现，看了解决的思路是unionFind,处于相同行或者列的点是联通的
     *
     * 38ms
     *
     * @param stones
     * @return
     */
    public int removeStones2(int[][] stones) {
        int length = stones.length;
        //这里的unionfind没有优化，没有降低其高度
        int[] roots = new int[length];
        for (int i = 0; i < length; i++) {
            roots[i] = i;
        }
        int ans = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                //处于相同的行或者列就可以union
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    int x = find(roots, i);
                    int y = find(roots, j);
                    if (x != y) {
                        roots[x] = y;
                        ans++;
                    }
                }
            }
        }


        return ans;
    }

    private int find(int[] root, int i) {
        while (root[i] != i) {
            i = root[i];
        }

        return i;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 
    ///////////////////////////////////////////////////////////////////////////


    Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;

    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; ++i)
            //这里无法理解
            union(stones[i][0], ~stones[i][1]);
        return stones.length - islands;
    }

    public int find(int x) {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (f.get(x) != y) {
            f.put(find(x), find(y));
            islands--;
        }
    }

}
