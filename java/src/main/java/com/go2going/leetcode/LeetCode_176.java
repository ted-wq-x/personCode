package com.go2going.leetcode;

public class LeetCode_176 {
    String sql = "select (select DISTINCT Salary  from Employee order by Salary desc limit 1,1) as SecondHighestSalary" ;
}
