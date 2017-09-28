package com.go2going;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 项目名称：  testcode<br>
 * 类名称：  CompletableFutureTest<br>
 * 描述：CompletableFuture测试<br>
 *     参考文章{@literal http://colobu.com/2016/02/29/Java-CompletableFuture/}和{@literal http://www.sczyh30.com/posts/Java/java-8-completable-future/}
 *
 * @author wangqiang
 * 创建时间：  2017/9/27 0027 16:20
 */
public class CompletableFutureTest {

    static Stream<Integer> getList(int size){
        return IntStream.range(0, size).boxed();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        basicOperator();
//        getOrJoin();
//        thenCompose();
        anyOfAndAllOf();
    }

    /**
     * 基本操作
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void basicOperator() throws ExecutionException, InterruptedException {
        CompletableFuture<Optional<Long>> optionalCompletableFuture = CompletableFuture.supplyAsync(() -> getList
                (10000)).thenApplyAsync(integerStream -> integerStream.map(Integer::toUnsignedLong).reduce((x,y)
                ->x+y));
        Long aLong = optionalCompletableFuture.get().orElse(0L);
        System.out.println(aLong);
    }

    /**
     *  比较get和join方法的区别,然而并没有看出来！！
     */
    static void getOrJoin() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> temp = CompletableFuture.supplyAsync(() -> {
            int i = 1 / 0;
            return 100;
        });
        System.out.println(temp.get());
        temp.join();
    }

    /**
     * thenCompose()
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void thenCompose() throws ExecutionException, InterruptedException {
        String s = CompletableFuture.supplyAsync(() -> 100).thenCompose(integer -> CompletableFuture.supplyAsync(()
                -> integer *
                2 + "")).get();

        assert s.equals("200");
    }

    /**
     * anyOf()、allOf()
     * @throws ExecutionException
     * @throws InterruptedException
     */
    static void anyOfAndAllOf() throws ExecutionException, InterruptedException {
        Random rand = new Random();
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000+rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000+rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "abc";
        });

        System.out.println(CompletableFuture.anyOf(future1, future2).get());
    }

}
