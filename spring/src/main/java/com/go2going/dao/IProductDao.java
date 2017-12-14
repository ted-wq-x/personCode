package com.go2going.dao;

import com.go2going.bean.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * 项目名称：  testcode<br>
 * 类名称：  IProductDao<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 10:17
 */
public interface IProductDao extends PagingAndSortingRepository<Product,Integer> {
    @Override
    Optional<Product> findById(@NonNull Integer integer);
    @Override
    <S extends Product> S save(@NonNull S entity);
}
