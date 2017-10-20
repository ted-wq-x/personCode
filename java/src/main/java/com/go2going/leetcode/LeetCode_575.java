package com.go2going.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LeetCode_575<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/10/19 0019 14:28
 */
public class LeetCode_575 {

    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) kinds.add(candy);

        //因为是对半分，所以比较总数量的一半和种类的大小
        //每个人的糖果的总数是一定的。
        int sum = candies.length / 2;
        int kind = kinds.size();
        return sum>=kind?kind:sum;
    }

    /**
     * 使用数据，实现种类的过滤并减少了次数，所以效率更高
     * @param candies
     * @return
     */
    public int distributeCandies1(int[] candies) {
        boolean[] kinds = new boolean[200001];
        int sum = 0;
        int length = candies.length;
        for (int i = 0; i < length; i++) {
            if (!kinds[100000 + candies[i]]) {
                kinds[100000 + candies[i]] = true;
                sum++;
            }
            //如果sister拿到的数量小于种类的话，就没必要继续计算种类了
            if (length / 2 <=sum)  {
                return sum;
            }
        }
        return sum;
    }
}
