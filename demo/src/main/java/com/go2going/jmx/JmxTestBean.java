package com.go2going.jmx;

import lombok.ToString;
import org.springframework.jmx.export.annotation.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 项目名称：  testcode<br>
 * 类名称：  JmxTestBean<br>
 * 描述：使用jconsole连接，每个注解都有不少的属性
 * 1、@ManagedAttribute查询注释
 *
 * @author wangqiang
 * 创建时间：  2017/12/5 0005 11:08
 */
@Component
@ToString
@ManagedResource(description = "test JMX bean")
public class JmxTestBean implements Serializable {


    private String name;
    private int age;
    private boolean isSuperman;

    @ManagedAttribute(defaultValue = "wq")
    public String getName() {
        return name;
    }
    @ManagedAttribute(defaultValue="scc")
    public void setName(String name) {
        this.name = name;
    }
    @ManagedAttribute(defaultValue = "25")
    public int getAge() {
        return age;
    }
    @ManagedAttribute(defaultValue = "22")
    public void setAge(int age) {
        this.age = age;
    }
    @ManagedAttribute(defaultValue = "true")
    public boolean isSuperman() {
        return isSuperman;
    }
    @ManagedAttribute(defaultValue = "false")
    public void setSuperman(boolean superman) {
        isSuperman = superman;
    }

    @ManagedOperation
    @ManagedOperationParameter(name = "name",description = "姓名")
    @ManagedOperationParameter(name = "age",description = "年龄")
    @ManagedOperationParameter(name = "isSuperman",description = "是不是超人")
    public void makeSomeOne(String name, Integer age, Boolean isSuperman) {
        this.name = name;
        this.age = age;
        this.isSuperman = isSuperman;
    }

    @ManagedOperation
    public JmxTestBean getBean(){
        return this;
    }
}
