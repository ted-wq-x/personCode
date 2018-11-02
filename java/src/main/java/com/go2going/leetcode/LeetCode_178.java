package com.go2going.leetcode;

public class LeetCode_178 {
    String sql = "SELECT\n" +
            "       Score,\n" +
            "       (SELECT count(distinct Score) FROM Scores WHERE Score >= s.Score) Rank\n" +
            "FROM Scores s\n" +
            "ORDER BY Score desc";
}
