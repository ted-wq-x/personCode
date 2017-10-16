package wangqiang.website.createType;

import java.util.function.Function;

/**
 * 简单工厂模式(静态工厂)-代码实现
 * 不符合开闭原则
 * Created by wangq on 2017/5/11.
 */
public class SimpleFactory {
    /**
     * 产品名称
     *
     * @param proName
     * @return
     */
    public static Product createProduct(String proName) {
        if ("A".equals(proName)) {
            return new ProductA();
        } else if ("B".equals(proName)) {
            return new ProductB();
        }
        return null;
    }

    public static void main(String[] args) {
        Function<String, Product> createProduct = SimpleFactory::createProduct;
        Product a = createProduct.apply("A");
        System.out.println(a);
    }

    /**
     * 抽象类
     */
    public static abstract class Product {

    }

    /**
     * 具体产品
     */
    public static class ProductA extends Product {

    }

    /**
     * 具体产品
     */
    public static class ProductB extends Product {

    }

}
