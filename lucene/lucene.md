## lucene的测试环境搭建

[参考文章](https://wiki.apache.org/lucene-java/HowtoConfigureIntelliJ)<br>
[用Intellij idea搭建solr调试环境](http://www.cnblogs.com/jeniss/p/5995921.html)

1. 按照官方文档走就行，注意在运行`ant idea`命令之前先配置代码，不然jar包下不了。
不过即使配置了代理还是很慢。

2. 注意如果idea没有配置好module的话，运行`ant clean-idea`先，然后在运行`ant idea`试试。

3. debug相关