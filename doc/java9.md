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