package com.go2going.leetcode;

public class LeetCode_175 {
    /**
     * ON, 定义表连接的条件
     * WHERE,定义表行记录的过滤条件
     * HAVING,定义分组的的过滤条件
     */
    String sql = "select p.FirstName,p.LastName,a.City,a.State from Person p left join Address  a on p.PersonId=a.PersonId";
}
