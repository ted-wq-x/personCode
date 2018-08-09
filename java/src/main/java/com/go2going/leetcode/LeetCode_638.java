package com.go2going.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int min = 0;
        for (int i = 0; i < price.size(); i++) {
            min += price.get(i) * needs.get(i);
        }

        for (List<Integer> sp : special) {
            List<Integer> newNeeds = new ArrayList<>();
            for (int i = 0; i < price.size(); i++) {
                if (sp.get(i) > needs.get(i)) {
                    newNeeds=null;
                    break;
                }
                newNeeds.add(needs.get(i) - sp.get(i));
            }

            if (newNeeds != null) {
                min = Math.min(min, shoppingOffers(price, special, newNeeds)+sp.get(sp.size()-1));
            }
        }

        return min;
    }
}
