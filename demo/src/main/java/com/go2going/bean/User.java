package com.go2going.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;

import java.io.Serializable;

/**
 * 项目名称：  testcode<br>
 * 类名称：  User<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/13 0013 15:18
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
//启用缓存
@CacheConfig(cacheManager = "cacheManager", cacheNames = "user")
public class User implements Serializable{
    private static final long serialVersionUID = 3044545286930389632L;
    @NonNull
    private String name;
    private Integer age;
}
