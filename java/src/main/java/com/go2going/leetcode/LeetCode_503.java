package com.go2going.leetcode;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class LeetCode_503 {
    public static void main(String[] args) {
        LeetCode_503 leetCode_503 = new LeetCode_503();
        int[] ints = leetCode_503.nextGreaterElements(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 110ms-->73ms
     * 通过观察答案nums的值都为正，其实这里不需要使用treemap使用stack就可以了
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        if (length == 0) {
            return ans;
        }
        Arrays.fill(ans, -1);
        //key=value
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        List<Integer> value = new ArrayList<>();
        value.add(0);
        treeMap.put(nums[0], value);
        //count 圈数
        int index = 1, count = 0;

        while (!treeMap.isEmpty() && count < 2) {
            if (index == length) {
                count++;
                index = 0;
            }
            int num = nums[index];
            Map.Entry<Integer, List<Integer>> lowerEntry = treeMap.lowerEntry(num);
            while (lowerEntry != null) {
                Integer key = lowerEntry.getKey();
                for (Integer integer : lowerEntry.getValue()) {
                    ans[integer] = num;
                }
                treeMap.remove(key);
                lowerEntry = treeMap.lowerEntry(num);
            }
            if (ans[index] == -1) {
                List<Integer> orDefault = treeMap.getOrDefault(num, new ArrayList<>());
                orDefault.add(index);
                treeMap.put(num, orDefault);
            }
            index++;

        }

        return ans;
    }

    public int[] nextGreaterElements3(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }
        return next;
    }

    static public int[] nextGreaterElements2(int[] nums) {
        int len=nums.length;
        int[] ret=new int[len];
        if (len==0) return ret;
        Arrays.fill(ret, -1);
        int index=0;
        for (int i=0; i<len; ++i) {
            if (nums[i]>nums[index]) index=i;
        }
        ret[index]=-1;
        for (int i=1; i<len; ++i) {
            int k=index-i;
            if (k<0) k+=len;
            if (nums[k]==nums[index]) {ret[k]=-1; continue;}
            int r=(k+1)%len;
            while (nums[r]<=nums[k]) {
                r=ret[r];
            }
            ret[k]=r;
        }
        for (int i=0; i<len; ++i) {
            if (ret[i]==-1) continue;
            ret[i]=nums[ret[i]];
        }
        return ret;
    }

}
