package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_901 {
    class StockSpanner {

        private List<Integer> dp = new ArrayList<>();
        private List<Integer> prices = new ArrayList<>();

        public StockSpanner() {

        }

        /**
         * 最直接的方式
         *
         * @param price
         * @return
         */
        public int next(int price) {
            int size = prices.size();
            if (prices.isEmpty() || price < prices.get(size - 1)) {
                dp.add(1);
            } else {
                int j = size - 1;
                while (j >= 0 && price >= prices.get(j)) {
                    j -= dp.get(j);
                }

                dp.add(size - j);
            }

            prices.add(price);

            return dp.get(size - 1);
        }
    }



    class StockSpanner2 {


        /**
         * https://zxi.mytechroad.com/blog/stack/leetcode-901-online-stock-span/
         */
        public StockSpanner2() {

        }
        private Stack<Integer> dp = new Stack<>();
        private Stack<Integer> prices = new Stack<>();

        /**
         * Monotonic Stack
         *
         * @param price
         * @return
         */
        public int next(int price) {
            int span = 1;

            while (!prices.isEmpty() && price >= prices.peek()) {
                prices.pop();
                span += dp.pop();
            }
            dp.push(span);
            prices.push(price);
            return span;
        }
    }
}
