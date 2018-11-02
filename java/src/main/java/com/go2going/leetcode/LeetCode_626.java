package com.go2going.leetcode;

public class LeetCode_626 {
    //前面的if判断个数，主要是用于处理最后的一个数，如果是偶数，则-1，奇数的话就不变
    String sql = "select if(id < (select count(*) from seat), if(id mod 2 = 0, id - 1, id + 1), if(id mod 2 = 0, id - 1, id)) as id,\n" +
            "       student\n" +
            "from seat\n" +
            "order by id asc;";
}
