package com.go2going.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.DefaultRedisCachePrefix;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：  testcode<br>
 * 类名称：  MyConfiguration<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/11 0011 17:04
 */

//获取配置
@Configuration
@Slf4j
@PropertySource("classpath:redis.properties")
public class MyConfiguration {

    @Value("${redis.url:localhost}")
    private String redisUrl;

    @Value("${redis.port:6379}")
    private Integer port;


    @Value("${redis.db:0}")
    private Integer db;


    @Bean
    MyInitializer initializer() {
        return new MyInitializer();
    }

    /**
     * 使用本地的currentHashMap作为缓存,只能有一个cacheManager
     *
     * @return
     */
    //        @Bean(name = "SimpleCacheManager")
    SimpleCacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        Set<Cache> set = new HashSet<>();
        //提供的缓存名称
        set.add(new ConcurrentMapCache("product"));
        simpleCacheManager.setCaches(set);
        return simpleCacheManager;
    }


    //    -------------------------------------------------------------------------------
    //  redis的有关类不能直接new，业务有的类当中有afterPropertiesSet方法，这个方法需要被beanFactory调用
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        log.info("BackKom redis config:url={},port={},db={}", redisUrl, port, db);
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName(redisUrl);
        connectionFactory.setDatabase(db);
        connectionFactory.setPort(port);
        return connectionFactory;
    }

    @Bean
    RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {

        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);

        //默认使用的是java序列化,这个序列化方法有个缺点，被添加缓存注解的方法参数必须是String类型，否则出错
        //        StringRedisSerializer serializer = new StringRedisSerializer();
        //        GenericToStringSerializer serializer=new GenericToStringSerializer()

        GenericJackson2JsonRedisSerializer serializer1 = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setValueSerializer(serializer1);
        redisTemplate.setHashValueSerializer(serializer1);

        //key的序列化
        redisTemplate.setKeySerializer(serializer1);
        redisTemplate.setHashKeySerializer(serializer1);

        return redisTemplate;
    }

    /**
     * 使用redis作为缓存
     *
     * @return
     */

    @Bean(name = "cacheManager")
    public RedisCacheManager redisCacheManager( RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        redisCacheManager.setTransactionAware(true);//添加事务
        //        redisCacheManager.setCacheNames();//只缓存指定的名称
        DefaultRedisCachePrefix prefix = new DefaultRedisCachePrefix("-->");
        redisCacheManager.setCachePrefix(prefix);
        redisCacheManager.setUsePrefix(true);
        redisCacheManager.setDefaultExpiration(60);//60ms
        //        redisCacheManager.setExpires();//根据key设置过期时间，可以实现非常灵活的过期策略
        return redisCacheManager;
    }

    //    -------------------------------------------------------------------------------

}
