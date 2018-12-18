## 总结

为了更快

1. 不要使用stream
2. 尽量使用数组，能不用集合就不用
3. for循环不要用foreach

### 贪心算法（Greedy）--455

### 不用临时变量交换两个数的值

原理是xor相同的两个数不变

```java
a ^= b;  
b ^= a;  
a ^= b;  
```

### 二叉搜索树算法
BST:二叉树上又加了个搜索的限制。其要求：每个节点比其左子树元素大，比其右子树元素小。

### 206单链表反转，第一次遇到不太容易理解，需注意

### 35使用dp算法

### 437使用dfs算法

### 82链表的递归很有意思，第一次见

### 438很难理解，43大神级的思路

### 46，77使用回溯算法，需要理解下，这个以前没遇到

### 105,106中关于二叉树的构造，需要学习，挺难的

### `Union find` 839 以前没遇到过

# 网上看到的五大常见算法

1. 贪婪算法
1. 动态规划算法(dp=> Dynamic planning)
1. 分治算法
1. 深度优先搜索(dfs=>Depth-first search)：[wiki](https://zh.wikipedia.org/wiki/%E6%B7%B1%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2)
1. 回溯算法
1. 图染色（二分图）:886，785
1. bitmap（处理大数据时使用，[BITMAP](https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/06.07.md)）



# 常见算法分类

1. 动态规划 (Dynamic programming)
1. 递归 (Recursion) 
1. 设计/数据结构 (Design/Data Structure)
1. 树 (Binary Tree) 
1. 搜索 (Search)
1. 图 (graph) :这类的题目都是medium之上的，都不简单
1. 哈希表 (HashTable) 
1. 贪心 (Greedy)
1. 链表 (Linked List)
1. 数学题 (Math) 
1. 几何 (Geometry)
1. 字符串 (String)
1. 模拟 (Simulation) 
1. 分治 (Divide and Conquer) 
1. 二分搜索(Binary Search)
1. Bit (位运算)：260是用XOR操作之后，分离出两个数的方法值得学习

### 原码，反码，补码

分析计算机在处理负数时的处理方式[知乎](https://www.zhihu.com/question/20159860)

