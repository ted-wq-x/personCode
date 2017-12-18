package com.go2going.dao;

import com.go2going.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 项目名称：  testcode<br>
 * 类名称：  IProductRepository<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/12/14 0014 10:17
 */
@Transactional(readOnly = true)
public interface IProductRepository extends JpaRepository<Product,Integer> {
}
