package wangqiang.website.createType;

/**
 * 建造者模式
 * Created by wangq on 2017/5/12.
 */
public abstract class Builder {

//    创建产品对象
    protected  Product product=new Product();
    abstract void buildPartA();
    abstract void buildPartB();
    abstract void buildPartC();

    Product getResult() {
        return product;
    }

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product construct = director.construct();
        System.out.println(construct);
    }
}

/**
 * 具体建造者
 */
class ConcreteBuilder extends Builder {

    @Override
    void buildPartA() {
        product.setPartA("轮子");
    }

    @Override
    void buildPartB() {
        product.setPartB("引擎");
    }

    @Override
    void buildPartC() {
        product.setPartC("车架");
    }
}

/**
 * 指挥者
 */
class Director {
    private  Builder builder;
    public  Director(Builder builder) {
        this.builder=builder;
    }
    public  void setBuilder(Builder builder) {
        this.builder=builder;
    }

    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}

/**
 * 产品
 */
class Product {
    private  String partA; //定义部件，部件可以是任意类型，包括值类型和引用类型
    private  String partB;
    private  String partC;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public String getPartC() {
        return partC;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}