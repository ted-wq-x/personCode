# guava 概览

很简单的或者java8已经有的，就不介绍了。由于java8中很多api的提升都是有参考guava，所以在最新的版本都有适配java8。

参考文章：
1. [guava中文教程](http://ifeve.com/google-guava/)
1. [guava官方wiki](https://github.com/google/guava/wiki)

## 基础工具

1. 避免空值，java8的前身，Optional
2. 前置条件,Preconditions
3. Object中常见的方法和ComparisonChain，该类是一个fluent风格.
4. Ordering,java8的Comparator借鉴了Ordering和ComparisonChain，且继承Comparator。
5. Throwables，简化异常和错误的传播与检查

## 集合

1. 不可变集合,首先介绍下不可变类的优点：
    * 当对象被不可信的库调用时，不可变形式是安全的；
    * 不可变对象被多个线程调用时，不存在竞态条件问题
    * 不可变集合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）；
    * 不可变对象因为有固定不变，可以作为常量来安全使用。
    
    在java9当中也有参考guava的实现。 JDK也提供了Collections.unmodifiableXXX方法把集合包装为不可变形式，但我们认为不够好：
   
    * 笨重而且累赘：不能舒适地用在所有想做防御性拷贝的场景；
    * 不安全：要保证没人通过原集合的引用进行修改，返回的集合才是事实上不可变的；
    * 低效：包装过的集合仍然保有可变集合的开销，比如并发修改的检查、散列表的额外空间，等等
    
    如果你没有修改某个集合的需求，或者希望某个集合保持不变时，把它防御性地拷贝到不可变集合是个很好的实践。
    
    重要提示：所有Guava不可变集合的实现都不接受null值。我们对Google内部的代码库做过详细研究，发现只有5%的情况需要在集合中允许null元素，
    剩下的95%场景都是遇到null值就快速失败。如果你需要在不可变集合中使用null，请使用JDK中的Collections.unmodifiableXXX方法。

2. 新的集合,Guava引入了很多JDK没有的、但我们发现明显有用的新集合类型。这些新类型是为了和JDK集合框架共存，而没有往JDK集合抽象中硬塞其他概念。
   作为一般规则，Guava集合非常精准地遵循了JDK接口契约。
   
   //TODO
   
3. 比jdk中集合工具类更强大的工具类,归纳如何

|集合接口	|属于JDK还是Guava	|对应的Guava工具类|
|---|---|---|
|Collection	|JDK	|Collections2：不要和java.util.Collections混淆|
|List	|JDK	|Lists|
|Set	|JDK	|Sets|
|SortedSet|	JDK	|Sets|
|Map	|JDK	|Maps|
|SortedMap	|JDK|	Maps|
|Queue	|JDK	|Queues|
|Multiset	|Guava|	Multisets|
|Multimap	|Guava|	Multimaps|
|BiMap	|Guava	|Maps|
|Table	|Guava	|Tables|

4. 集合扩展工具类

## 缓存

适用场景：

* 你愿意消耗一些内存空间来提升速度。
* 你预料到某些键会被查询一次以上。
* 缓存中存放的数据总量不会超出内存容量

[参考文章](http://www.jianshu.com/p/64b0df87e51b)

## 函数式风格

这个就不提了

## 并发

1. Service框架，于封装一个服务对象的运行状态、包括start和stop等方法。
2. ListenableFuture,被java8的CompletableFuture取代

## 字符串处理：分割，连接，填充

1. 连接器[Joiner]，拆分器[Splitter]，字符匹配器[CharMatcher]，字符集[Charsets]，大小写格式[CaseFormat]

## 原生类型

扩展 JDK 未提供的原生类型（如int、char）操作， 包括某些类型的无符号形式

## 区间

可比较类型的区间API，包括连续和离散类型

## I/O

简化I/O尤其是I/O流和文件的操作，针对Java5和6版本

## 散列

提供比Object.hashCode()更复杂的散列实现，并提供布鲁姆过滤器的实现

## 事件总线

发布-订阅模式的组件通信，但组件不需要显式地注册到其他组件中

##  数学运算

优化的、充分测试的数学工具类

## 反射

Guava 的 Java 反射机制工具类