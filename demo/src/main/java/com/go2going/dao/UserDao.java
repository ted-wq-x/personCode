package com.go2going.dao;

import com.go2going.bean.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 项目名称：  testcode<br>
 * 类名称：  UserDao<br>
 * 描述：基于 proxy 的 spring aop 带来的内部调用问题，如getUserIdByNameTest<br>
 *      和内部调用问题类似，非 public 方法如果想实现基于注释的缓存，必须采用基于 AspectJ 的 AOP 机制
 * @author wangqiang
 * 创建时间：  2017/12/13 0013 15:13
 */
@Repository
public class UserDao {

    //cacheNames的意思是缓存的名字，要和cacheManager提供的符合
    @Caching(cacheable = {@Cacheable(cacheNames = "user", key = "#user.name")},

            //这个注释可以确保方法被执行，同时方法的返回值也被记录到缓存中，例如更新数据库数据同时更新缓存数据
            put = {@CachePut(cacheNames = "user", condition = "#user.age eq 22")},

            //清除缓存,在满足condition的条件下删除单个缓存，如果内部抛出异常测无法删除，此时可以使用beforeInvocation=true
            //在删除之前进行清理
            evict = {@CacheEvict(cacheNames = "user", key = "#user.name", condition = "#user.age eq 12")})
    public String getUserIdByName(User user) {
        System.out.println("调用getUserIdByName：" + user.getName());

        return ThreadLocalRandom.current().nextInt() + user.getName();
    }

    /**
     * 该方法无法使用aop，所以就无法缓存
     * @param user
     * @return
     */
    public String getUserIdByNameTest(User user) {
        return this.getUserIdByName(user);
    }
}
