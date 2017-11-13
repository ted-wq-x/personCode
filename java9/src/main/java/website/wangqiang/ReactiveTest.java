package website.wangqiang;


import website.wangqiang.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * 项目名称：  testcode<br>
 * 类名称：  ReactiveTest<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/30 0030 14:25
 */
public class ReactiveTest {


   private static SubmissionPublisher<Person> publisher = new SubmissionPublisher<>();
    private static Random random = new Random();

    public static void main(String[] args) {

        publisher.subscribe(new TeacherSubscriber());

        publisher.consume(person -> {
            System.out.println("publish ---->"+person);
        });

        while (true) {
            publisher.submit(product());
            //即使调用cancle方法，也无法结束
            if (!publisher.hasSubscribers()) {
                System.out.println("GAME-------------------OVER");
                return;
            }
        }

    }

    private static Person product(){
//        return new Person(RandomStringUtils.randomAlphanumeric(5), random.nextInt());
        return null;
    }


    /**
     * 订阅者
     */
    static class TeacherSubscriber implements Flow.Subscriber<Person> {
        private static final int SIZE = 50;

        private int count=0;

        private List<Person> personList = new ArrayList<>();

        private Flow.Subscription subscription;


        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            System.out.println("开始订阅");
            this.subscription = subscription;
            subscription.request(10);
        }

        @Override
        public void onNext(Person item) {
            personList.add(item);
            count++;
            if (count >= SIZE) {
                subscription.cancel();
            } else if (count %10==0) {
                subscription.request(10);
            }
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println("Error-----------------------TeacherSubscriber");
        }

        @Override
        public void onComplete() {
            System.out.println("教师的学生满了"+personList.size());
        }
    }

    /**
     * 没法使用自定义的消息体
     */
    private static class MySubscription implements Flow.Subscription {

        @Override
        public void request(long n) {

        }

        @Override
        public void cancel() {

        }
    }
}





