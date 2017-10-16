package wangqiang.website.StructuralType;

/**
 * 装饰着模式（包装器）<br>
 * 抽象的装饰器，用于对具体构件的调用，添加的职责在其子类中实现
 * Created by wangqiang on 17-5-14.
 */
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }

    /**
     * 对于客户端来说无论是装饰之前的对象还是装饰之后的对象都可以一致对待。
     * @param args
     */
    public static void main(String[] args) {
//        Component decorator = new ConcreteDecorator(new ConcteteComponet());
        Component decorator = new ConcteteComponet();
        decorator.operation();
    }
}

/**
 * 抽象构件
 */
interface Component {
    void operation();
}

/**
 * 具体构件
 */
class ConcteteComponet implements Component {

    @Override
    public void operation() {
        System.out.println("吃饭！");
    }
}


/**
 * 具体装饰类，实现职责的拓展
 */
class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        this.addBehavior();
        super.operation();
    }

    /**
     * 新增的职责
     */
    private void addBehavior() {
        System.out.println("饭前洗手！");
    }
}