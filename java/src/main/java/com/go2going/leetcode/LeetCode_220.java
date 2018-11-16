package com.go2going.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class LeetCode_220 {
    public static void main(String[] args) {
        LeetCode_220 leetCode_220=new LeetCode_220();
        // System.out.println(leetCode_220.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        // System.out.println(leetCode_220.containsNearbyAlmostDuplicate(new int[]{2, 2}, 3,0));//true
        // System.out.println(leetCode_220.containsNearbyAlmostDuplicate(new int[]{7, 2,8}, 2,1));//true
        System.out.println(leetCode_220.containsNearbyAlmostDuplicate(new int[]{4,1,6,3}, 100,1));//true
        System.out.println(leetCode_220.containsNearbyAlmostDuplicate2(new int[]{4,1,6,3}, 100,1));//true
    }


    /**
     * GG
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;

        if (length <2||k==0) {
            return false;
        }

        //最后一位坑定不可能
        int[] mins = new int[length-1];
        int[] maxs = new int[length-1];

        /**
         * 使用最大值和最小值判断，但是containsNearbyAlmostDuplicate2(new int[]{4,1,6,3}, 100,1)，打脸了
         */
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int j = 1; j <= k&&j<length; j++) {
            minQueue.add(nums[j]);
            maxQueue.add(nums[j]);
        }

        mins[0] = minQueue.peek();
        maxs[0]= maxQueue.peek();
        for (int i = 1; i < length-1; i++) {
            minQueue.remove(nums[i]);
            maxQueue.remove(nums[i]);
            if (i + k<length){
                minQueue.add(nums[i + k]);
                maxQueue.add(nums[i + k]);
            }
            mins[i] = minQueue.peek();
            maxs[i] = maxQueue.peek();
        }
        for (int i = 0; i < mins.length; i++) {
            if (Math.abs((long)mins[i]-(long)nums[i])<=t||Math.abs((long)maxs[i]-(long)nums[i])<=t) {
                return true;
            }
        }

        return false;
    }

    /**
     * 第二种思路，思路很简单华东窗口，关系是关系没搞明白，浪费了很多时间
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int length = nums.length;

        if (length <2||k==0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < length; i++) {

            Long floor = set.floor((long)nums[i]);
            Long ceiling = set.ceiling((long)nums[i]);

            //这个没整明白，导致思路完全偏了
            if ((floor != null && nums[i]-floor  <= t) || (ceiling != null && ceiling-nums[i]  <= t)) {
                return true;
            }

            if (i >= k) {
                set.remove((long)nums[i - k]);
            }

            set.add((long)nums[i]);

        }

        return false;
    }


    /**
     * 这个思路是真的棒
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            //将元素进行手动存放，hash的位置能够确定
            //最靠近这个元素的在邻居桶或者当前桶
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long)nums[i]);
            //使用桶作为窗口，当超过窗口宽度时，需要删除之前的
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }

    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

}
