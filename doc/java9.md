# java9的几个重要特性的学习

## Jigsaw

模块化系统：
1. `requires <module>`定义该模块所依赖的模块
2. `requires transitive <module>`，`transitive`传递的意思 //TODO
3. `requires static <module>` 这种依赖关系检查在编译时是必需的，在运行时是可选的。
4. `exports <package-name>` 该模块将包导出到其他模块。如果包不被导出，其他模块不能使用这个包。
5. `open <package-name>` 表示在运行时可以通过反射访问此包（包涵私有方法），在编译时只能访问public的方法。
6. `open <package> to <module>` 和上面的差别就是，指定了可以访问的包。
7. `uses and provides`,`uses <service-interface>`表示interface在这个module中，implementation在别的模块（当然自己module也可以）
，`provides <service-interface> with <class1>,<class2>`表示对接口提供的哪些实现

注意：
1. module可以open
2. 在open module内部不能使用open
3. 在`module-info.java`中无法添加module的版本信息

## Flow-api



## Streams-api

## Collections 

-----

## java9中的包结构

1. java.activation：JavaBeans Activation Framework (JAF) API,关于什么是jaf，[参考文章](https://stackoverflow.com/questions/3067164/what-is-jaf-what-is-its-purpose)
2. java.base：java的基础内容，也是关注的重点。
3. java.compiler：定义语言模型，注释处理和Java编译器API。
4. java.corba：java语言的OMG corba(公共对象请求代理体系cobra是omg组织的一个规范)和RMI-IIOP相关api。 Java Remote Method Invocation (RMI) mechanism and the Common Object Request Broker Architecture (CORBA)。
[参考文章](http://www.oracle.com/technetwork/articles/javase/rmi-corba-136641.html)以及[维基百科](https://zh.wikipedia.org/wiki/CORBA)
5. java.datatransfer：定义应用程序之间如何传递数据的api
6. java.desktop：awt和swing相关内容
7. java.instrument：定义代理程序运行在jvm上的服务
8. java.jnlp：java network launching protocol,java网络执行协议文件，是java提供的一种可以通过浏览器直接执行java应用程序的途径，它使你可以直接通过一个网页上的url链接打开一个java应用程序。
9. java.logging：java的日志api
10. java.management：java的jmx相关api
11. java.management.rmi：jmx的rmi形式
12. java.naming：java的jdni(Java Naming and Directory Interface)相关接口
13. java.prefs：定义Preferences API.Preferences用来存储应用程序的配置数据，windows在注册表中，linux在用户目录的home文件夹下的隐藏文件中
14. java.rmi：远程方法调用
15. java.scripting：java脚本语言的api接口
16. java.se 空的
17. java.se.ee 空的
18. java.security.jgss：java版本的 Generic Security Services API (GSS-API)
19. java.security.sasl：java版本的Simple Authentication and Security Layer(SASL)
20. java.smartcardio： Java Smart Card I/O API
21. java.sql：jdbc
22. java.sql.rowset：jdbc的rowset相关api
23. java.transaction：jta的子类实现从而支持corba

----

xml相关

24. java.xml：定义用于XML处理的Java API（JAXP），Streaming API for XML（StAX），Simple API for XML（SAX）和W3C文档对象模型（DOM）API。
25. java.xml.bind：定义 Java Architecture for XML Binding (JAXB) API
26. java.xml.crypto：xml加密的api
27. java.xml.ws：基于xml的webservice相关api
28. java.sml.ws.annotation：注解

----

javafx ui相关的工具，比swing和awt好使点

29. javafx.base
30. javafx.controls
31. javafx.deploy
32. javafx.fxml
33. javafx.graphics
34. javafx.media
35. javafx.swing
36. javafx.web

-----

37. jdk.accessibility：辅助工具
37. jdk.attach：attach api
38. jdk.charsets：提供java.base中不存在的charset
39. jdk.compiler：java编译器相关的脚本命令

----

jdk提供的加密

40. jdk.crypto.cryptoki：
41. jdk.crypto.ec：
42. jdk.crypto.mscapi：

----
大致看了下jdk开头的包，目前来说我是看不懂

