## maven的模块化

使用idea进行maven的模块化配置

新建maven项目，删除src目录，添加新的模块即可，其他配置由idea完成

模块之间的依赖，在模块下的pom文件中添加即可，如：
```xml
<dependency>
    <groupId>com.com.go2going</groupId>
    <artifactId>web-service</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```