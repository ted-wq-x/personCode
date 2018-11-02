package com.go2going.leetcode;

public class LeetCode_183 {
    String sql = "select Name as Customers from Customers where Id not in (select distinct c.Id from Customers c ,Orders o where c.Id =o.CustomerId)";
    String sql2 = "SELECT Customers.Name as Customers FROM Customers LEFT JOIN Orders ON Customers.Id = Orders.CustomerId WHERE Orders.Id is NULL";

}
