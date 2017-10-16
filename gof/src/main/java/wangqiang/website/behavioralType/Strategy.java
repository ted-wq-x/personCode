package wangqiang.website.behavioralType;

/**
 * 策略模式<br>
 * 定义一系列算法，将每一个算法封装起来，并让它们可以相互替换。策略模式让算法独立于使用它的客户而变化，也称为政策模式(Policy)。
 * Created by wangqiang on 17-5-16.
 */
public abstract class Strategy {
    public abstract void algorithmInterface();

    /**
     * 上下文
     */
    static class Context {
        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public void run() {
            strategy.algorithmInterface();
        }
    }

    public static void main(String[] args) {
        Context context = new Context(new ConcreteStrategyA());
        context.run();
        context = new Context(new ConcreteStrategyB());
        context.run();
    }
}

class ConcreteStrategyA extends Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("算法A");
    }
}

class ConcreteStrategyB extends Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("算法B");
    }
}

