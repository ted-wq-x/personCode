package wangqiang.website.behavioralType;

/**
 * 状态模式<br>
 *     抽象状态类<br>
 *     允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。其别名为状态对象(Objects for States)，状态模式是一种对象行为型模式
 * Created by wangqiang on 17-5-16.
 */
public abstract class State {

    public abstract void handle(Context context);

    public static void main(String[] args) {
        Context context = new Context(new ConcreteStateA());
        context.request();
        context.request();
    }
}

/**
 * 维护state实例
 */
class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request(){
        state.handle(this);
        System.out.println("当前状态："+state.getClass().getName());
    }


}

/**
 * 具体的状态
 */
class ConcreteStateA extends State {
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB extends State {
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}