package com.go2going.java9;

import com.go2going.lambda.model.Person;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 项目名称：  testcode<br>
 * 类名称：  ReactivePublisher<br>
 * 描述：reactive flow stream例子
 *
 * @author wangqiang
 * 创建时间：  2017/9/26 0026 16:02
 */
public class ReactivePublisher{

    private ForkJoinPool pool = ForkJoinPool.commonPool();


    public static void main(String[] args) {
        try (SubmissionPublisher<Person> publisher = new SubmissionPublisher<>();) {

            //添加一个订阅者
//            CompletableFuture<Void> subTask = publisher.consume(person -> {
//                //do something 这是一种消费的方式
//            });



            SimpleSubscriber sub1 = new SimpleSubscriber("S1", 2);
            SimpleSubscriber sub2 = new SimpleSubscriber("S2", 5);
            SimpleSubscriber sub3 = new SimpleSubscriber("S3", 6);
            SimpleSubscriber sub4 = new SimpleSubscriber("S4", 10);
            // Subscriber to the publisher
            publisher.subscribe(sub1);
            publisher.subscribe(sub2);
            publisher.subscribe(sub3);


            //发布数据
            getRandomPerson(10).forEach(publisher::submit);

            Thread.sleep(2000);
            publisher.subscribe(sub4);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试默认的publisher
     */
    static void submissionPublisherTest() {
        try (SubmissionPublisher<Person> publisher = new SubmissionPublisher<>();) {

            //添加一个订阅者
//            CompletableFuture<Void> subTask = publisher.consume(person -> {
//                //do something 这是一种消费的方式
//            });


            //发布数据
            getRandomPerson(5).forEach(publisher::submit);

            //睡5s后通知结束
            Thread.sleep(5000);
            publisher.getSubscribers().forEach(Flow.Subscriber::onComplete);

            //阻塞的方法，
            //subTask.get();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 产生随机的数据
     *
     * @param size
     * @return
     */
    static List<Person> getRandomPerson(int size) {
        List<Person> personLIst = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            Person p = new Person(RandomStringUtils.randomAlphanumeric(5), random.nextInt());
            personLIst.add(p);
        }

        return personLIst;
    }
}

/**
 * 创建person对象的消费者
 */
class SimpleSubscriber implements Flow.Subscriber<Person> {
    //保存当前获取的消息
    private Flow.Subscription subscription;

    //消费者的姓名
    private String name;

    //自大的接受数量
    private long maxCount;

    private int counter;

    public SimpleSubscriber(String name,long maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    /**
     * 当订阅时触发
     * @param subscription
     */
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.printf("%s subscribed with max count %d.%n", name, maxCount);
        subscription.request(maxCount);
    }

    @Override
    public void onNext(Person item) {
        counter++;
        System.out.printf("%s received %s.%n", name, item);
        if (counter >= maxCount) {
            System.out.printf("Cancelling %s. Processed item count: %d.%n", name, counter);
            // Cancel the subscription
            subscription.cancel();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.printf("An error occurred in %s: %s.%n", name, throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.printf("%s is complete.%n", name);
    }
}
