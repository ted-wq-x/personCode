package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class LeetCode_932 {
    public static void main(String[] args) {
        LeetCode_932 leetCode_932 = new LeetCode_932();
        System.out.println(Arrays.toString(leetCode_932.beautifulArray(10)));
    }

    /**
     * 自己尝试找出规律，但是发现不行，参考https://leetcode.com/problems/beautiful-array/discuss/186679/C++JavaPython-Odd-+-Even-Pattern-O(N)的思路
     * <p>
     * A1 = A * 2 - 1 is beautiful with only odds from 1 to N * 2 -1
     * A2 = A * 2 is beautiful with only even from 2 to N * 2
     * B = A1 + A2 beautiful array with length N * 2
     *
     * f(n)=[f(n-1)*2-1]+[f(n-1)*2]
     *
     * @param N
     * @return
     */
    public int[] beautifulArray(int N) {
        //递归
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        while (ans.size() < N) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i : ans) {
                //范围判断防止超了
                if (i * 2 - 1 <= N) {
                    temp.add(i * 2 - 1);
                }
            }

            for (int i : ans) {
                //范围判断防止超了
                if (i * 2 <= N) {
                    temp.add(i * 2);
                }
            }
            ans = temp;
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
