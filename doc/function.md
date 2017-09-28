# 函数式接口的别名SAM（Single Abstract method）

`java.util.function`中定义了几组类型的函数式接口以及针对基本数据类型的子接口

* Predicate -- 传入一个参数，返回一个bool结果， 方法为boolean test(T t)
* Consumer -- 传入一个参数，无返回值，纯消费。 方法为void accept(T t)
* Function -- 传入一个参数，返回一个结果，方法为R apply(T t)
* Supplier -- 无参数传入，返回一个结果，方法为T get()
* UnaryOperator -- 一元操作符， 继承Function,传入参数的类型和返回类型相同。
* BinaryOperator -- 二元操作符， 传入的两个参数的类型和返回类型相同， 继承BiFunction

注意事项： 

1. 函数式接口中可以额外定义多个抽象方法，但这些抽象方法签名必须和Object的public方法一样，如t`oString,hashCode,equals`。
2. 接口中的抽象方法也可以抛出异常，但是注意在lambda表达式中如果抛出异常，而接口中没有声明这个异常，则该接口不能作为lambda接口。
3. java8中可以在接口中声明静态方法，ps：提醒下。
4. @FunctionInterface注释不是必须的，该注释只是用于提醒读者




