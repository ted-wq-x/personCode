package com.go2going.bean;

import lombok.Data;
import org.springframework.cache.annotation.CacheConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Product<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 10:36
 */
@Data
@Entity
@Table(name = "product")
//启用缓存
@CacheConfig(cacheManager = "cacheManager", cacheNames = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = -5031578723902467316L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column
    private Date productDate;
}
