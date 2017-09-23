
## lambda

lambda表达式目的是实现将方法/函数作为参数传递给另一个方法/函数。

对lambda的理解，在java8之前的代码如下：
```java
new Thread(new Runnable() {
                @Override
                public void run() {
                    //动作             
                }
            }).start();
```

对于Thread类而言，是通过接口实现方法参数化，间接实现的。也就是通过匿名内部类的形式实现。
而lambda就是这个匿名内部类的简写，这种形态就是：`(方法参数)->{方法体}`。
所以上面的例子就变成：
```java
new Thread(()->{
    //动作
}).start();
```



#### [lambda和方法引用的区别](https://www.zhihu.com/question/51491241),参考这个。