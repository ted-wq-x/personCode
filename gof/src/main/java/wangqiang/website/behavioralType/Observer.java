package wangqiang.website.behavioralType;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式（发布-订阅）
 * Created by wangqiang on 17-5-16.
 */
public abstract class Observer {
    public abstract void update();

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver("wq",subject));
        subject.attach(new ConcreteObserver("scc",subject));
        subject.attach(new ConcreteObserver("ls",subject));
        subject.setSubjectState("110");
        subject.notifyA();
    }
}

/**
 * 主题
 */
abstract class Subject {
    private List<Observer> observers = new ArrayList<>();//订阅主题的观察者

    /**
     * 添加观察者
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者
     * @param observer
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有的观察者
     */
    public void notifyA(){
        observers.forEach(observer -> observer.update());
    }
}

/**
 * 具体的主题
 */
class ConcreteSubject extends Subject {
    private String subjectState;//主题保存的信息

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}

/**
 * 具体观察者
 */
class ConcreteObserver extends Observer {
    private String name;
    private String observerState;
    private ConcreteSubject subject;

    public ConcreteObserver(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }


    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.println("观察者:"+name+"最新的状态为"+observerState);
    }
}