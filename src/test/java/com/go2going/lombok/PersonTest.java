package com.go2going.lombok;

import org.junit.Test;

/**
 * 项目名称：  testcode
 * 类名称：  PersonTest
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/22 0022 15:50
 */
public class PersonTest {

    @Test
    public void val(){
        Person person = new Person("wq", "www", 12);
        System.out.println(person);

    }
}
