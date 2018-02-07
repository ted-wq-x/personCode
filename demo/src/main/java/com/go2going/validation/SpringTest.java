package com.go2going.validation;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 项目名称：  testcode<br>
 * 类名称：  SpringTest<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2018/2/5 0005 12:58
 */
public class SpringTest {
    public static void main(String[] args) {

    }
}


class PersonValidation implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

@Data
class Person {
    private String name;
    private Integer age;
    private Address address;
}

@Data
class Address {
    private String location;
    private int nums;
}