package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LeetCode_373 {

    public static void main(String[] args) {
        LeetCode_373 leetCode_373 = new LeetCode_373();
        System.out.println(leetCode_373.kSmallestPairs2(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10));
    }

    /**
     * 58ms
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        //数组的第三位表示，在num2中所使用的index
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<int[]> res = new ArrayList<>();
        int length2 = nums2.length;
        if (nums1.length == 0 || length2 == 0 || k == 0) {
            return res;
        }
        //先将num2[0]和num1进行配对
        for (int i = 0; i < nums1.length && i < k; i++){
            que.offer(new int[]{nums1[i], nums2[0],0});
        }
        while (k-- > 0 && !que.isEmpty()) {
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if (cur[2]+1 >= length2) {
                continue;
            }
            //取出一个后，添加一个新的配对，这个配对是num2的index+1，这个很好理解，比当前大的只有nums2中的index+1的数了，小的都已经放到ans中了
            que.offer(new int[]{cur[0], nums2[cur[2]+1],cur[2]+1});
        }
        return res;
    }

    /**
     * 268ms
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<>(k);
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0 || length2 == 0 || k == 0) {
            return ans;
        }

        Map<Integer, List<int[]>> map3 = new TreeMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                int key = i + j;
                List<int[]> orDefault = map3.getOrDefault(key, new ArrayList<>());
                orDefault.add(new int[]{i, j});
                map3.put(key, orDefault);
            }
        }

        for (Map.Entry<Integer, List<int[]>> entry : map3.entrySet()) {
            List<int[]> value = entry.getValue();
            for (int[] ints : value) {
                int i = ints[0];
                int j = ints[1];
                ans.add(new int[]{i, j});
                if (--k <= 0) {
                    return ans;
                }
            }
        }
        return ans;
    }

}
