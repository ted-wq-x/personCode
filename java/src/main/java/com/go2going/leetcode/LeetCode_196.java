package com.go2going.leetcode;

public class LeetCode_196 {
    String sql = " delete p1 from Person p1,Person p2 where p1.Email=p2.Email and p1.Id>p2.Id";
    String sql2 = " delete  from Person  where Id not in (select p.id from (select min(Id) as id from Person group by Email) as p)";
}
