package com.go2going.method;

/**
 * 项目名称：  testcode<br>
 * 类名称：  interfaceTest3<br>
 * 描述：不同签名的方法也是很难分辨的,Java会选择最适合的方法
 *
 * @author wangqiang
 * 创建时间：  2017/9/28 0028 10:36
 */
public interface interfaceTest3 {
    interface A {
        default void say(int a) {
            System.out.println("A");
        }
    }
    interface B {
        default void say(short a) {
            System.out.println("B");
        }
    }
    interface C extends A,B{
    }
    class D implements C {
    }

    static void main(String[] args) {
            D d = new D();
            byte a = 1;
            d.say(a); //B
    }
}
