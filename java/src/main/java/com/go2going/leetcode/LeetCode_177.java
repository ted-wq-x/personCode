package com.go2going.leetcode;

public class LeetCode_177 {
    String sql = "CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT\n" +
            "  BEGIN\n" +
            "    declare M int;\n" +
            "    set M=N-1;\n" +
            "    RETURN (\n" +
            "           # Write your MySQL query statement below.\n" +
            "           select distinct Salary from Employee group by Salary desc limit M,1\n" +
            "           );\n" +
            "\n" +
            "  END";
}
