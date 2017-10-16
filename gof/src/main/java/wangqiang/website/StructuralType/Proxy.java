package wangqiang.website.StructuralType;

/**
 * 代理模式
 * Created by wangqiang on 17-5-14.
 */
public class Proxy {
    public static void main(String[] args) {
        Subject subject = new RealSubjectProxy();
        subject.Request();
    }
}

/**
 * 抽象主题角色
 */
abstract class Subject {
    public abstract void Request();
}

/**
 * 真实主题角色
 */
class RealSubject extends Subject {
    @Override
    public void Request() {
        //业务方法具体实现代码
        System.out.println("hahahha");
    }
}

/**
 * 代理主题角色
 */
class RealSubjectProxy extends Subject {
    private RealSubject realSubject = new RealSubject(); //维持一个对真实主题对象的引用

    public void PreRequest() {
        System.out.println("前置通知");
    }

    @Override
    public void Request() {
        PreRequest();
        realSubject.Request(); //调用真实主题对象的方法
        PostRequest();
    }

    public void PostRequest() {
        System.out.println("后置通知");
    }
}