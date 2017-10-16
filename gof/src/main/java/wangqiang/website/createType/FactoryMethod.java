package wangqiang.website.createType;

/**
 * 工厂方法模式<p>
 *
 * 工厂方法模式是简单工厂模式的进一步抽象和推广。<p>
 * 由于使用了面向对象的多态性，工厂方法模式保持了简单工厂模式的优点，而且克服了它的缺点。在工厂方法模式中，核心的工厂类不再负责所有产品的创建，而是将具体创建工作交给子类去做。<p>
 * 这个核心类仅仅负责给出具体工厂必须实现的接口，而不负责哪一个产品类被实例化这种细节，这使得工厂方法模式可以允许系统在不修改工厂角色的情况下引进新产品。<p>
 *
 * Created by wangq on 2017/5/11.
 */
public class FactoryMethod {

    public static void main(String[] args) {
        Factory factory = new ConcreteFactory();
        Product product = factory.factoryMethod();
        System.out.println(product);
    }

    /**
     * 抽象产品
     */
    public static abstract class Product {

    }

    /**
     * 抽象工厂
     */
    public static abstract class Factory {
        public abstract Product factoryMethod();
    }

    /**
     * 具体产品
     */
    public static class ConcreteProduct extends Product {

    }

    /**
     * 具体工厂
     */
    public static class ConcreteFactory extends Factory {
        @Override
        public Product factoryMethod() {
            return new ConcreteProduct();
        }
    }


}
