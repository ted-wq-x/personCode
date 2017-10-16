package wangqiang.website.behavioralType;

/**
 * 中介者模式（调停者模式）<br>
 *     使得对象间的相互调用所组成的网状结构变为星型结构<br>
 *         中介者抽象类
 *
 * Created by wangqiang on 17-5-15.
 */
public abstract class Mediator {
    public abstract void send(String message, Colleague colleague);

    public static void main(String[] args) {
        ContreteMediator mediator = new ContreteMediator();
        ContreteColleague1 colleague1 = new ContreteColleague1(mediator);
        ContreteColleague2 colleague2 = new ContreteColleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);
        colleague1.send("我是同事1，你好");
        colleague2.send("你好，我是同事2");
    }
}

/**
 * 抽象同事类,使用中介者和其他具体的同事类通讯
 */
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}

/**
 * 具体的同事
 */
class ContreteColleague1 extends Colleague {
    public ContreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message,this);
    }

    public void nofity(String message) {
        System.out.println("同事一收到："+message);
    }
}

/**
 * 具体的同事
 */
class ContreteColleague2 extends Colleague {
    public ContreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        mediator.send(message,this);
    }

    public void nofity(String message) {
        System.out.println("同事二收到："+message);
    }
}

/**
 * 具体的中介者，如果对象定义的比较复杂会使得具体的中介者很臃肿
 */
class ContreteMediator extends Mediator {

    private ContreteColleague2 colleague2;
    private ContreteColleague1 colleague1;

    public void setColleague2(ContreteColleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    public void setColleague1(ContreteColleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.nofity(message);
        } else {
            colleague1.nofity(message);
        }
    }
}