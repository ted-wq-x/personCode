package com.go2going.controller;

import com.go2going.bean.Product;
import com.go2going.dao.IProductDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private IProductDao productDao;

    @GetMapping("/getUser")
    @ResponseBody
    @Cacheable(cacheNames = "product", key = "#id")
    public Product getUser(@RequestParam Integer id) {
        log.info("Enter getUser method:id={}",id);
        return productDao.findById(id).orElse(null);
    }

    @PostMapping("/addUser")
    @ResponseBody
    @Cacheable(cacheNames = "product", key = "#product.id")
    public ResponseEntity<Product> saveUser( Product product) {
        log.info("Enter saveUser method:product={}",product);
        Product save = productDao.save(product);
        return new ResponseEntity<>(save,HttpStatus.OK);
    }
}
