package wangqiang.website.behavioralType;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令模式，动作模式，事物模式   <br>
 * 抽象命令类
 * Created by wangqiang on 17-5-14.
 */
public abstract class Command {
    Receiver receiver; //维持一个对请求接收者对象的引用

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    abstract void execute();
}

/**
 * 具体命令类(烤玉米)
 */
class ConcreteCommandA extends Command {


    ConcreteCommandA(Receiver receiver) {
        super(receiver);
    }

    @Override
    void execute() {
        receiver.actionA(); //调用请求接收者的业务处理方法action()
    }
}

/**
 * 具体命令类(烤鸡翅)
 */
class ConcreteCommandB extends Command {


    ConcreteCommandB(Receiver receiver) {
        super(receiver);
    }

    @Override
    void execute() {
        receiver.actionB(); //调用请求接收者的业务处理方法action()
    }
}


/**
 * 命令的调用者(服务员)
 */
class Invoker1 {
    private Command command;

    Invoker1() {
    }

    //设值注入
    void setCommand(Command command) {
        this.command = command;
    }

    //业务方法，用于调用命令类的execute()方法
    void call() {
        command.execute();
    }
}

/**
 * 命令的调用者(服务员)
 */
class Invoker2 {
    private List<Command> commandList = new ArrayList<>();

    void setOrder(Command command) {
//        对命令的过滤，添加日志等操作
//        .....
        commandList.add(command);
    }

    public void cancleCommand(Command command) {
        commandList.remove(command);
    }

    //业务方法，用于调用命令类的execute()方法
    void call() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}


/**
 * 接受者（烧烤师傅）
 */
class Receiver {

    void actionA() {
        System.out.println("烤玉米");
    }

    void actionB() {
        System.out.println("烤鸡翅");
    }
}

/**
 * 客户类
 */
class Client {

    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 第一种实现
     */
    private static void test1() {
        Receiver receiver = new Receiver();//烧烤师傅
        Command barbecueCorn = new ConcreteCommandA(receiver);
        Command barbecueWings = new ConcreteCommandB(receiver);
        Invoker1 invoker = new Invoker1(); //服务员

        invoker.setCommand(barbecueCorn);
        invoker.call();
        invoker.setCommand(barbecueWings);
        invoker.call();
    }

    /**
     * 第一种实现
     */
    private static void test2() {
        Receiver receiver = new Receiver();//烧烤师傅
        Command barbecueCorn = new ConcreteCommandA(receiver);
        Command barbecueWings = new ConcreteCommandB(receiver);
        Invoker2 invoker = new Invoker2(); //服务员
        invoker.setOrder(barbecueCorn);
        invoker.setOrder(barbecueWings);
        invoker.call();
    }
}