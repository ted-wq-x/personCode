package com.go2going.method;

/**
 * 项目名称：  testcode<br>
 * 类名称：  interfaceTest2<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/28 0028 10:33
 */
public interface interfaceTest2 {
    interface A {
        default void say(String name) {

        }
    }

    interface B {
        default void say(int age) {

        }
    }

    /**
     * 由于默认方法不同，所以无需重写
     */
    interface C extends A, B {
    }

}


