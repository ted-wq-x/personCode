package com.go2going.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.Set;

/**
 * 项目名称：  testcode<br>
 * 类名称：  Main<br>
 * 描述：
 *
 * @author wangqiang
 * 创建时间：  2017/9/29 0029 9:47
 */
public class Main {

    public static void main(String[] args) {
        ValidatorFactory validator = Validation.buildDefaultValidatorFactory();
        User user = new User("wq", 22);
        Validator vs = validator.getValidator();
        Set<ConstraintViolation<User>> validate = vs.validate(user, Default.class);
        System.out.println(validate.iterator().next().getMessage());
    }
}
