package com.go2going.leetcode;

public class LeetCode_184 {
    String sql = "SELECT D.Name AS Department ,E.Name AS Employee ,E.Salary\n" +
            "from\n" +
            "     Employee E,\n" +
            "     Department D\n" +
            "WHERE E.DepartmentId = D.id\n" +
            "  AND (DepartmentId,Salary) in\n" +
            "      (SELECT DepartmentId,max(Salary) as max FROM Employee GROUP BY DepartmentId)";
}
