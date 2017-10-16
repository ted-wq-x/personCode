package wangqiang.website.createType;

/**
 * 抽象工厂模式
 * Created by wangq on 2017/5/11.
 */
public abstract class AbstractFactory {

    public abstract AbstractProductA createProcuctA();
    public abstract AbstractProductB createProcuctB();

    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory2();
        AbstractProductB procuctA = factory.createProcuctB();
        System.out.println(procuctA.toString());
    }
}

/**
 * 产品族，如电视
 */
abstract class AbstractProductA {

}

/**
 * 具体产品，如一工厂的电视
 */
class ProductA1 extends AbstractProductA{
    @Override
    public String toString() {
        return "一工厂:wangqiang.website.createType.ProductA1";
    }
}

/**
 * 具体产品，如二工厂的电视
 */
class ProductA2 extends AbstractProductA{
    @Override
    public String toString() {
        return "二工厂:wangqiang.website.createType.ProductA1";
    }
}

/**
 * 产品族，如电脑
 */
abstract class AbstractProductB {

}

/**
 * 具体产品，如一工厂的电脑
 */
class ProductB1 extends AbstractProductB{
    @Override
    public String toString() {
        return "一工厂:wangqiang.website.createType.ProductB1";
    }
}

/**
 * 具体产品，如二工厂的电脑
 */
class ProductB2 extends AbstractProductB{
    @Override
    public String toString() {
        return "二工厂:wangqiang.website.createType.ProductB2";
    }
}

/**
 * 工厂2
 */
class ConcreteFactory2 extends AbstractFactory {
    @Override
    public AbstractProductA createProcuctA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProcuctB() {
        return new ProductB2();
    }
}

/**
 * 工厂1
 */
class ConcreteFactory1 extends AbstractFactory {
    @Override
    public AbstractProductA createProcuctA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProcuctB() {
        return new ProductB1();
    }

}