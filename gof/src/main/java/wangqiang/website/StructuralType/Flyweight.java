package wangqiang.website.StructuralType;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式 <br>
 * 抽象享元类
 * Created by wangqiang on 17-5-14.
 */
public abstract class Flyweight {
    public abstract void operation();

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
    }
}

/**
 * 具体享元类
 */
class ConcreteFlyweight extends Flyweight {
    private Integer intrinsicState;

    public ConcreteFlyweight(Integer intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation() {

    }
}

/**
 * 非共享具体享元类
 */
class UnsharedConcreteFlyweight extends Flyweight {
    private Integer allState;

    public UnsharedConcreteFlyweight(Integer allState) {
        this.allState = allState;
    }

    @Override
    public void operation() {

    }
}

/**
 * 享元工厂类
 */
class FlyweightFactory {
    private Map<String, Flyweight> mpFlyweight = new HashMap<>();

    private Flyweight getFlyweight(String key){
        if (mpFlyweight.containsKey(key)) {
            return mpFlyweight.get(key);
        } else {
            ConcreteFlyweight concreteFlyweight = new ConcreteFlyweight(null);
            mpFlyweight.put(key,concreteFlyweight);
            return concreteFlyweight;
        }

    }
}