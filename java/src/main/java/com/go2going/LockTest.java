package com.go2going;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SplittableRandom;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

/**
 * 项目名称：  testcode<br>
 * 类名称：  LockTest<br>
 * 描述：java8新的锁，stampedLock<br>
 *     在什么情况下使用什么样的锁，需要根据实际情况进行选择，每种锁都有自己的优势<br>
 *         参考文章
 *         <a href="http://colobu.com/2016/06/01/Java-8-StampedLocks-vs-ReadWriteLocks-and-Synchronized/">不同锁的简单测试</a>
 *
 * @author wangqiang
 * 创建时间：  2017/9/27 0027 19:18
 */
public class LockTest {

    private static final SplittableRandom random = new SplittableRandom();

    private static final   Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new LruCache<>(5));

    public static void main(String[] args) throws InterruptedException {



        StampedLock lock = new StampedLock();

        //加锁
        long stamp = lock.writeLock();

        //释放锁
        lock.unlock(stamp);



    }

    static void testLru(){
        IntStream.range(1,1000).forEach(value -> {
            int i = random.nextInt(10);
            objectObjectMap.put(i, value);

        });
        objectObjectMap.forEach((o, o2) -> System.out.println("key="+o+",value="+o2));
    }


}

/**
 * 最简单的lru缓存
 * @param <K>
 * @param <V>
 */
class LruCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LruCache(int cacheSize) {
        super(16,0.75f,true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size()>cacheSize;
    }

}

