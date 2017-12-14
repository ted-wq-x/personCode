package com.go2going.config;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
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

//@ComponentScan(basePackages = "com.go2going")
//启用缓存
@EnableCaching()
@CacheConfig(cacheManager = "RedisCacheManager", cacheNames = "product")
//@CacheConfig(cacheManager = "SimpleCacheManager", cacheNames = "测试")

//获取配置
@PropertySource("classpath:redis.properties")

@Configuration
@EnableJpaRepositories(value = "com.go2going.dao")
@EnableTransactionManagement
public class MyConfiguration {

    @Autowired
    private Environment env;

    @Bean
    MyInitializer initializer() {
        return new MyInitializer();
    }

    /**
     * 使用本地的currentHashMap作为缓存
     *
     * @return
     */
    //    @Bean(name = "SimpleCacheManager")
    SimpleCacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        Set<Cache> set = new HashSet<>();
        //提供的缓存名称
        set.add(new ConcurrentMapCache("user"));
        simpleCacheManager.setCaches(set);
        return simpleCacheManager;
    }

    /**
     * 使用redis作为缓存
     *
     * @return
     */
    @Bean(name = "RedisCacheManager")
    public RedisCacheManager getRedisCacheManager() {
        String url = env.getProperty("redis.url");
        Assert.assertNotNull(url);
        String port = env.getProperty("redis.port");
        Assert.assertNotNull(port);
        RedisStandaloneConfiguration standaloneConfiguration = new RedisStandaloneConfiguration();
        standaloneConfiguration.setHostName(url);
        standaloneConfiguration.setPort(Integer.parseInt(port));
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(standaloneConfiguration);
        return RedisCacheManager.builder(connectionFactory).
                cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().
                                prefixKeysWith("wqTest")//缓存的前缀
                        //.entryTtl(Duration.ofSeconds(1))//设置过期时间
                ).
                transactionAware().//添加事务
                build();
    }

    @Bean("MyDataSource")
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

}
