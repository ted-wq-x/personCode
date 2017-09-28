package com.go2going.method;

/**
 * 项目名称：  testcode<br>
 * 类名称：  interfaceTest<br>
 * 描述：java8的多继承<br>
 *     接口中存在相同的默认方法
 *
 * @author wangqiang
 * 创建时间：  2017/9/28 0028 10:27
 */
public interface interfaceTest {

    interface A{

        default void saay(){
            System.out.println("A");
        }
    }

    interface B{

        default void saay(){
            System.out.println("B");
        }
    }

    /**
     * 必须重写default方法
     */
    interface C extends A,B {

        @Override
        default void saay() {
            System.out.println("C");
        }
    }

    class CT implements C {
    }

    public static void main(String[] args) {
        CT ct = new CT();
        ct.saay();//print C
    }
}

