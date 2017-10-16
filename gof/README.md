## 学习设计模式

:muscle: 比较不错的学习资源 [https://github.com/me115/design_patterns](http://design-patterns.readthedocs.io/zh_CN/latest/read_uml.html)和[https://gof.quanke.name/](https://gof.quanke.name/)

设计模式的几个设计原则需要牢记，还是很有用的老哥。

1. 单一职责原则定义如下： 单一职责原则(Single Responsibility Principle, SRP)：一个类只负责一个功能领域中的相应职责，或者可以定义为：就一个类而言，应该只有一个引起它变化的原因。
2. 开闭原则(Open-Closed Principle, OCP)：一个软件实体应当对扩展开放，对修改关闭。即软件实体应尽量在不修改原有代码的情况下进行扩展。
3. 里氏代换原则(Liskov Substitution Principle, LSP)：所有引用基类（父类）的地方必须能透明地使用其子类的对象。
4. 依赖倒转原则(Dependency Inversion Principle, DIP)：抽象不应该依赖于细节，细节应当依赖于抽象。换言之，要针对接口编程，而不是针对实现编程。
5. 接口隔离原则(Interface Segregation Principle, ISP)：使用多个专门的接口，而不使用单一的总接口，即客户端不应该依赖那些它不需要的接口。
6. 合成复用原则(Composite Reuse Principle, CRP)：尽量使用对象组合，而不是继承来达到复用的目的。
7. 迪米特法则(Law of Demeter, LoD)：一个软件实体应当尽可能少地与其他实体发生相互作用。(中介者模式就是其中一种解决方式)

## 小结

1. 策略模式：
定义了算法族，分别分装起来，让他们之间可以互相替换，此模式让算法的变换独立于使用算法的客户。

2. 观察者模式：
定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新

3. 装饰者模式：
动态的将责任附加到对象身上。想要拓展功能，装饰者提供有别于继承的另外一种选择。

## 注意

注意下面三个模式之间很像，需要小心。
1. 装饰者模式：不改变接口，但加入职责
2. 适配器模式：将一个接口转换成另一个接口
3. 外观模式： 让接口更简单
