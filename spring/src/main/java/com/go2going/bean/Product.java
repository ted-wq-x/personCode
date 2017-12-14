package com.go2going.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
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
public class Product implements Serializable {

    private String name;
    @Id
    @GeneratedValue
    private Integer id;
    private Date productDate;
}
