package com.go2going.stream;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.LongStream;

/**
 * 在stream中使用了大量的lambda，不要被吓着，看下function描述基本就清除了
 * 方法参见{@link java.util.stream}
 */
public class StreamsTest {
    public static void main(String[] args) {
        basicOperation();
    }

    /**
     * 流的基本操作,filter,sorted,map(对每个元素进行操作，返回新的流，这就是和foreach的区别),Match,Count,Reduce
     */
    static void basicOperation(){
        List<String> objects = getRandomList(10);
        objects.stream().filter(s->s.startsWith("a")).forEach(System.out::println);
    }

    /**
     * 获取随机list
     * @param size
     * @return
     */
    static List<String> getRandomList(int size){
        List<String> objects = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            String s1 = RandomStringUtils.randomAlphanumeric(5);

            objects.add(s1);
        }

        return objects;
    }

    /**
     * 并发测试，是否用并发方式还得具体分析慢的原因，得慎重考虑
     */
    static void parallelStream(){
        long l = System.currentTimeMillis();
        OptionalLong reduce = LongStream.rangeClosed(1, 100).parallel().reduce((a, b) -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return a + b;
        });
        System.out.println(reduce.orElse(0));
        System.out.println(System.currentTimeMillis()-l);
    }

}
