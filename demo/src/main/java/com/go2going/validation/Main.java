package com.go2going.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
        Location location = new Location(33, 44);
        User user = new User(null, 44,location);
        Validator vs = validator.getValidator();
        //groups分为三个组，其中一个为default
        //只会校验name
        go(Default.class, vs, user);

        //校验 age
        go(GroupTest1.class, vs, user);

        //校验Location
        go(GroupTest2.class, vs, user);
    }

    private static void go(Class c,Validator vs,User user) {
        Set<ConstraintViolation<User>> validate = vs.validate(user, c);
        if (validate.size() != 0) {
            validate.forEach(System.out::println);
        }
        System.out.println("-------------------------------------------");
    }
}
