package wangqiang.website.StructuralType;

/**
 * 桥接模式
 * 桥接模式将继承关系转换为关联关系，从而降低了类与类之间的耦合，减少了代码编写量。
 * Created by wangq on 2017/5/12.
 */
public class Bridge {

    public static void main(String[] args) {
        Abstraction abstraction = new RefinedAbstraction();
        abstraction.setImplementor(new ConcreteImplementorB());
        abstraction.operation();
    }
}

/**
 * 抽象类
 */
abstract class Abstraction {
    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    abstract void operation();
}

/**
 * 扩充抽象类
 */
class RefinedAbstraction extends Abstraction {
    @Override
    void operation() {
        //业务代码
        System.out.println("正方形");
        implementor.operationImpl(); //调用实现类的方法
    }
}


/**
 * 实现类接口
 */
interface Implementor {
    void operationImpl();
}

/**
 * 具体实现类
 */
class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("red");
    }
}

/**
 * 具体实现类
 */
class ConcreteImplementorB implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("yellow");
    }
}