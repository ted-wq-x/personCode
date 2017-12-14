/**
 * 项目名称：  testcode<br>
 * 类名称：  package-info<br>
 * 描述：
 * 几种解决方案：
 * 1.不使用Static，每次使用时，创建新实例。但是查看源码后会发现这个对象很重，在并发的情况下非常的消耗资源
 * 2.使用synchronized，严重影响并发性
 * 3.ThreadLocal，为每个线程创建一个，想想也不是很合适
 * 4.使用Apache的工具类，能保证线程安全和高效，但是参数和方法有不少的局限性
 * 5.java8的DateTimeFormatter 是线程安全的，但是性能就不知道了
 * 6.使用Joda-Time，基本ok，但我自己没使用过
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 16:05
 */
package com.go2going.DateTest;