package wangqiang.website.StructuralType;

/**
 * 适配器模式
 * 将一个接口转换成客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作，其别名为包装器(Wrapper)。适配器模式既可以作为类结构型模式，也可以作为对象结构型模式。
 * Created by wangq on 2017/5/12.
 */
public class Adapter {
}

/**
 * 客户类
 */
class Client {
    public static void main(String[] args) {
        Target target = new ConcreteAdapter(new Adaptee());
        target.request();
    }
}

/**
 * 目标抽象类，可以是类,接口或者抽象类
 */
abstract class Target{
    abstract void request();
}

/**
 * 适配器
 */
class ConcreteAdapter extends Target {
    private Adaptee adaptee = new Adaptee();//维持一个适配者对象的调用

    public ConcreteAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    void request() {
        adaptee.specificRequest();//转发调用
    }
}

/**
 * 被适配类
 */
class Adaptee {

    void specificRequest() {

    }
}