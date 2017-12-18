package com.go2going.controller;

import com.go2going.bean.Product;
import com.go2going.bean.User;
import com.go2going.dao.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 项目名称：  testcode<br>
 * 类名称：  IndexController<br>
 * 描述：spring方式的jpa真的是无法忍受，xml配置实在是太烦了
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 10:08
 */
@Controller
@Slf4j
public class IndexController {

    @Resource
    private IProductRepository productDao;

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("/hello")
    @ResponseBody
    public String index(@RequestParam String name, @RequestParam Boolean isOk) {
        log.debug("BackKom index method para:name={},isOk={}", name, isOk);
        return "world";
    }


    @GetMapping("/getUser")
    @ResponseBody
    @Cacheable(cacheNames = "user", key = "#who")
    public User getUser(@RequestParam String who) {
        log.info("Enter getUser method:who={}", who);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        User user = new User("wq", 88);
        valueOperations.set("me", user);
        return user;
    }


    @GetMapping("/getProduct")
    @ResponseBody
    @Cacheable(cacheNames = "product", key = "#id")
    public Product getProduct(@RequestParam Integer id) {
        log.info("Enter getProduct method:id={}", id);
        return productDao.findOne(id);
    }

    @PostMapping("/updateUser")
    @ResponseBody
    //更新缓存
    @CachePut(cacheNames = "product", key = "#product.id")
    public Product updateUser(Product product) {
        log.info("Enter saveUser method:product={}", product);

        if (product.getId() == null) {
            return null;
        }
        Product save = productDao.saveAndFlush(product);
        //        return new ResponseEntity<>(save, HttpStatus.OK);无法序列化到redis当中
        return save;
    }


    @DeleteMapping("/deleteUser")
    @ResponseBody
    //    删除缓存
    @CacheEvict(cacheNames = "product", key = "#id")
    public ResponseEntity deleteUser(@RequestParam Integer id) {
        log.info("Enter deleteUser method:id={}", id);
        productDao.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/addUser")
    @ResponseBody
    //    @Cacheable(cacheNames = "product", key = "#product.id")
    public ResponseEntity<Product> saveUser(Product product) {
        log.info("Enter saveUser method:product={}", product);
        Product save = productDao.save(product);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/getUserNoCache")
    @ResponseBody
    public Product getUserNoCache(@RequestParam Integer id) {
        log.info("Enter getUserNoCache method:id={}", id);
        return productDao.findOne(id);
    }

    /**
     * 初始化数据库数据
     */
    @PostConstruct
    public void saveDataTODb() {


        long count = productDao.count();
        log.info("DB size={}", count);

        if (count != 0L) {
            return;
        }
        Product product1 = new Product();
        product1.setName("wq");
        List<Product> list = new ArrayList<>();

        product1.setProductDate(new Date());

        Product product2 = new Product();
        product2.setName("scc");
        product2.setProductDate(new Date());

        Product product3 = new Product();
        product3.setName("ls");
        product3.setProductDate(new Date());

        Product product4 = new Product();
        product4.setName("cjh");
        product4.setProductDate(new Date());
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        productDao.save(list);

    }

    @PreDestroy
    public void destory() {
        redisTemplate.delete("me");
    }
}
